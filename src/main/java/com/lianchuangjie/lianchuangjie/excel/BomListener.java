package com.lianchuangjie.lianchuangjie.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomSubEntity;
import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryError;
import com.lianchuangjie.lianchuangjie.mapper.SdadaMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.BomDicService;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
@Component
public class BomListener extends AnalysisEventListener<Map<Integer, String>> {
    @Resource
    SdadaMapper sdadaMapper;
    @Resource
    BomDicService bomDicService;
    //声明一个静态变量来存储
    public static BomListener bomListener;

    @PostConstruct
    public void init() {
        bomListener = this;
    }

    // 去除特殊字符的正则表达式
    public final static String REGEX_ALL_BRACKETS = "<.*?>|\\(.*?\\)|（.*?）|\\[.*?]|【.*?】|\\{.*?}|\\(.*?）|（.*?\\)";
    private final Pattern pattern = Pattern.compile(REGEX_ALL_BRACKETS);

    // 型号、品牌、备注、数量字段名字典
    private List<String> modelNameList;
    private List<String> brandNameList;
    private List<String> remarkNameList;
    private List<String> quantityNameList;
    // 读取到的数据
    private final List<Map<String, String>> dataList = new ArrayList<>();
    // 读取到的型号列表
    private final List<String> modleList = new ArrayList<>();
    // BOM单条目
    private final List<BomSubEntity> bomSubList = new ArrayList<>();
    private Long lineNum = Long.parseLong("1");
    // 是否开始读取数据
    private Boolean startRead = false;
    // 型号列索引
    private Integer modleIndex;

    public Integer getModleIndex() {
        return modleIndex;
    }

    // 品牌列索引
    private Integer brandIndex;

    public Integer getBrandIndex() {
        return brandIndex;
    }

    // 数量列索引
    private Integer quantityIndex;
    // 备注列索引
    private Integer remarkIndex;
    // 标题行
    private Map<Integer, String> titleMap = new HashMap<>();

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public List<String> getModleList() {
        return modleList;
    }

    public List<BomSubEntity> getBomSubList() {
        return bomSubList;
    }

    // 获取表头索引行列表
    public List<String> getTitleList() {
        List<String> titleList = new ArrayList<>(titleMap.values());
        titleList.add("系统预处理品牌");
        titleList.add("系统预处理型号");
        titleList.add("行号");
        return titleList;
    }

    // 读取首行数据
    @Override
    public void invokeHeadMap(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        log.info("解析第一行数据:{}", JSON.toJSONString(dataMap));
        // 加载索引匹配字典
        this.modelNameList = bomListener.bomDicService.getModleNameList();
        this.brandNameList = bomListener.bomDicService.getBrandNameList();
        this.remarkNameList = bomListener.bomDicService.getRemarkNameList();
        this.quantityNameList = bomListener.bomDicService.getQuantityNameList();
        // 如果首行就是索引行
        if (this.isIndexRow(dataMap)) {
            getColumnIndex(dataMap);
            startRead = true;
            titleMap = dataMap;
        }
    }

    // 读取表格数据
    @Override
    public void invoke(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        // 行索引
        int index = analysisContext.readRowHolder().getRowIndex();
        log.debug("解析到第{}行数据：{}", index + 1, dataMap);
        // 读取有效数据, 如果一直找到索引行了则开始读取表格数据, 否则继续查找标题行
        if (startRead && null != modleIndex) {
            modleList.add(dataMap.get(modleIndex));
            BomSubEntity item = new BomSubEntity();
            item.setLineNum(lineNum);
            String modle = handleModle(dataMap, item);
            item.setModle(modle);
            item.setStandModle(modle);
            String brand = handleBrand(dataMap, item);
            item.setBrand(brand);
            item.setStandBrand(brand);
            item.setDemandQty(new BigDecimal(dataMap.get(quantityIndex) == null ? "0" : dataMap.get(quantityIndex)));
            item.setModle(dataMap.get(modleIndex));
            item.setCurRemark(dataMap.get(remarkIndex));
            bomSubList.add(item);
            // 根据原表的表头索引重新构造每行数据
            Map<String, String> map = new HashMap<>();
            for (int key : titleMap.keySet()) {
                String title = titleMap.get(key);
                String value = dataMap.get(key);
                if (title == null) {
                    continue;
                }
                map.put(title, value);
            }
            // 增加一个行号
            map.put("行号", lineNum.toString());
            // 增加一列 用于处理品牌
            map.put("系统预处理品牌", item.getBrand());
            // 增加一列 用于处理型号
            map.put("系统预处理型号", item.getModle());
            lineNum += 1;
            dataList.add(map);
        } else if (!startRead && this.isIndexRow(dataMap)) {
            startRead = true;
            this.getColumnIndex(dataMap);
            titleMap = dataMap;
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.debug("读取完成");
    }

    /**
     * 判断是否包含型号近义词,如果包含则为索引行
     *
     * @param sdada sdada
     * @return boolean
     */
    private Boolean isIndexRow(Map<Integer, String> sdada) {
        boolean flag = Boolean.FALSE;
        for (String modleName : modelNameList) {
            flag = sdada.containsValue(modleName);
            if (flag) break;
        }
        return flag;
    }

    /**
     * @param rowIndexRow rowIndexRow
     * @description 解析列索行, 识别型号、品牌、数量列
     */
    private void getColumnIndex(Map<Integer, String> rowIndexRow) {
        for (Integer key : rowIndexRow.keySet()) {
            if (modelNameList.contains(rowIndexRow.get(key))) {
                log.debug("Modle->" + rowIndexRow.get(key));
                modleIndex = key;
            } else if (brandNameList.contains(rowIndexRow.get(key))) {
                log.debug("Brand->" + rowIndexRow.get(key));
                brandIndex = key;
            } else if (quantityNameList.contains(rowIndexRow.get(key))) {
                log.debug("Quantity->" + rowIndexRow.get(key));
                quantityIndex = key;
            } else if (remarkNameList.contains(rowIndexRow.get(key))) {
                log.debug("Remark->" + rowIndexRow.get(key));
                remarkIndex = key;
            }
        }
        EnquiryError.VALID_ERROR.assertNotNull(modleIndex, "未识别到型号列");
    }

    /**
     * @description 处理型号
     */
    private String handleModle(Map<Integer, String> rowData, BomSubEntity item) {
        if (modleIndex == null) {
            return "型号不能为空";
        }
        String modle = rowData.get(modleIndex);
        if (pattern.matcher(modle).find()) {
            item.setStatus(item.getStatus() + "系统已去除型号中的特殊字符；");
            return modle.replaceAll(REGEX_ALL_BRACKETS, ""); // 型号去除特殊字符
        } else {
            return modle;
        }
    }

    /**
     * @description 处理品牌，品牌必须标准化
     */
    private String handleBrand(Map<Integer, String> rowData, BomSubEntity item) {
        // 如果BOM单有品牌列
        if (brandIndex != null) {
            String brand = rowData.get(brandIndex);
            if (brand != null) {
                if (pattern.matcher(brand).find()) {
                    item.setStatus(item.getStatus() + "系统已去除品牌中的特殊字符；");
                    return rowData.get(brandIndex).replaceAll(REGEX_ALL_BRACKETS, ""); // 品牌去除特殊字符
                } else {
                    return brand;
                }
            } else {
                // 原品牌为空时匹配品牌，如果该型号品牌唯一则返回该品牌否则置空
                List<SdadaVO> sdadaVOList = bomListener.sdadaMapper.selectContain(rowData.get(modleIndex));
                if (sdadaVOList.size() == 1) {
                    item.setStatus(item.getStatus() + "需求品牌为空，系统匹配到该型号对应的品牌；");
                    return sdadaVOList.get(0).getQuoBrand();
                } else {
                    item.setStatus(item.getStatus() + "需求品牌为空，系统匹配到该型号对应多个品牌需手动选择；");
                }
            }
        } else {
            // 如果BOM单没有品牌列
            List<SdadaVO> sdadaVOList = bomListener.sdadaMapper.selectContain(rowData.get(modleIndex));
            if (sdadaVOList.size() == 1) {
                item.setStatus(item.getStatus() + "无需求品牌列，系统匹配到该型号对应的品牌；");
                return sdadaVOList.get(0).getQuoBrand();
            } else {
                item.setStatus(item.getStatus() + "无需求品牌列，系统匹配到该型号对应多个品牌需手动选择；");
            }
        }
        return "";
    }
}
