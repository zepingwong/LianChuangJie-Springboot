package com.lianchuangjie.lianchuangjie.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.lianchuangjie.lianchuangjie.entity.BomHeadDicEntity;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryError;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.BomHeadDicMapper;
import com.lianchuangjie.lianchuangjie.mapper.SdadaMapper;
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

@Slf4j
@Component
public class BomListener extends AnalysisEventListener<Map<Integer, String>> {
    @Resource
    SdadaMapper sdadaMapper;
    @Resource
    BomHeadDicMapper bomHeadDicMapper;
    //声明一个静态变量来存储
    public static BomListener bomListener;
    @PostConstruct
    public  void init(){
        bomListener = this;
    }
    // 去除特殊字符的正则表达式
    public final static String REGEX_ALL_BRACKETS = "<.*?>|\\(.*?\\)|（.*?）|\\[.*?]|【.*?】|\\{.*?}|\\(.*?）|（.*?\\)";
    private BomHeadDicEntity bomHeadDic;
    // 读取到的数据
    private final List<Map<String, String>> dataList = new ArrayList<>();
    // 读取到的型号列表
    private final List<String> modleList = new ArrayList<>();
    // 读取到的品牌列表
    private final List<String> brandList = new ArrayList<>();
    // 数量
    private final List<Integer> quantityList = new ArrayList<>();
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

    public List<String> getBrandList() {
        return brandList;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public List<BomSubEntity> getBomSubList() {
        return bomSubList;
    }
    // 获取表头索引行列表
    public List<String> getTitleList() {
        List<String> titleList = new ArrayList<>(titleMap.values());
        titleList.add("标准化品牌");
        titleList.add("标准号型号");
        titleList.add("行号");
        return titleList;
    }
    // 读取首行数据
    @Override
    public void invokeHeadMap(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        log.info("解析第一行数据:{}", JSON.toJSONString(dataMap));
        // 加载索引匹配字典
        this.bomHeadDic = bomListener.bomHeadDicMapper.selectById(1);
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
            brandList.add(dataMap.get(brandIndex));
            quantityList.add(Integer.valueOf(dataMap.get(quantityIndex) == null ? "0" : dataMap.get(quantityIndex)));
            BomSubEntity item = new BomSubEntity();
            item.setLineNum(lineNum);
            item.setModle(handleModle(dataMap));
            item.setBrand(handleBrand(dataMap));
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
            // 增加一列 用于标准化品牌
            map.put("标准化品牌", item.getBrand());
            // 增加一列 用于标准化型号
            map.put("标准化型号", item.getModle());
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
     * @param sdada sdada
     * @return boolean
     */
    private Boolean isIndexRow(Map<Integer, String> sdada) {
        boolean flag = Boolean.FALSE;
        for (String modle:bomHeadDic.getModleList()) {
            flag = sdada.containsValue(modle);
            if (flag) break;
        }
        return flag;
    }
    /**
     * @description 解析列索行, 识别型号、品牌、数量列
     * @param rowIndexRow rowIndexRow
     */
    private void getColumnIndex(Map<Integer, String> rowIndexRow) {
        for (Integer key : rowIndexRow.keySet()) {
            if (bomHeadDic.getModleList().contains(rowIndexRow.get(key))) {
                log.debug("Modle->" + rowIndexRow.get(key));
                modleIndex = key;
            } else if (bomHeadDic.getBrandList().contains(rowIndexRow.get(key))) {
                log.debug("Brand->" + rowIndexRow.get(key));
                brandIndex = key;
            } else if (bomHeadDic.getQuantityList().contains(rowIndexRow.get(key))) {
                log.debug("Quantity->" + rowIndexRow.get(key));
                quantityIndex = key;
            } else if (bomHeadDic.getRemarkList().contains(rowIndexRow.get(key))) {
                log.debug("Remark->" + rowIndexRow.get(key));
                remarkIndex = key;
            }
        }
        EnquiryError.VALID_ERROR.assertNotNull(modleIndex, "未识别到型号列");
    }
    /**
     * @description 处理型号
     */
    private String handleModle(Map<Integer, String> rowData) {
        if (modleIndex == null) {
            return "型号不能为空";
        }
        return rowData.get(modleIndex).replaceAll(REGEX_ALL_BRACKETS, ""); // 型号去除特殊字符
    }
    /**
     * @description 处理品牌
     */
    private String handleBrand(Map<Integer, String> rowData) {
        // 如果BOM单有品牌列
        if (brandIndex != null) {
            if (rowData.get(brandIndex) != null) {
                return rowData.get(brandIndex).replaceAll(REGEX_ALL_BRACKETS, ""); // 品牌去除特殊字符
            } else {
                // 原品牌为空时匹配品牌，如果该型号品牌唯一则返回该品牌否则置空
                List<SdadaVO> sdadaVOList = bomListener.sdadaMapper.selectContain(rowData.get(modleIndex));
                if (sdadaVOList.size() == 1) {
                    return sdadaVOList.get(0).getQuoBrand();
                }
            }
        } else {
            // 原品牌为空时匹配品牌，如果该型号品牌唯一则返回该品牌否则置空
            List<SdadaVO> sdadaVOList = bomListener.sdadaMapper.selectContain(rowData.get(modleIndex));
            if (sdadaVOList.size() == 1) {
                return sdadaVOList.get(0).getQuoBrand();
            }
        }
        return "品牌不能为空";
    }
}
