package com.lianchuangjie.lianchuangjie.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.lianchuangjie.lianchuangjie.entity.BomHeadDicEntity;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class BomListener extends AnalysisEventListener<Map<Integer, String>> {
    public final static String REGEX_ALL_BRACKETS = "<.*?>|\\(.*?\\)|（.*?）|\\[.*?]|【.*?】|\\{.*?}|\\(.*?）|（.*?\\)";
    private final BomHeadDicEntity bomHeadDic;
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
    private final List<String> titleList = new ArrayList<>();
    private Long lineNum;
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
    public BomListener(BomHeadDicEntity bomHeadDic) {
        this.bomHeadDic = bomHeadDic;
        this.lineNum = Long.parseLong("1");
    }

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

    public List<String> getTitleList() {
        return titleList;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        log.info("解析到一条头数据:{}", JSON.toJSONString(dataMap));
    }

    @Override
    public void invoke(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        // 行索引
        int index = analysisContext.readRowHolder().getRowIndex();
        log.debug("解析到第{}行数据：{}", index + 1, dataMap);
        // 读取有效数据
        if (startRead && null != modleIndex) {
            modleList.add(dataMap.get(modleIndex));
            brandList.add(dataMap.get(brandIndex));

            quantityList.add(Integer.valueOf(dataMap.get(quantityIndex) == null ? "0" : dataMap.get(quantityIndex)));
            BomSubEntity item = new BomSubEntity();
            item.setLineNum(lineNum);
            item.setBrand(dataMap.get(brandIndex).replaceAll(REGEX_ALL_BRACKETS, "")); // 品牌去除特殊字符
            item.setModle(dataMap.get(modleIndex).replaceAll(REGEX_ALL_BRACKETS, "")); // 型号去除特殊字符
            item.setDemandQty(new BigDecimal(dataMap.get(quantityIndex) == null ? "0" : dataMap.get(quantityIndex)));
            item.setModle(dataMap.get(modleIndex));
            item.setCurRemark(dataMap.get(remarkIndex));
            bomSubList.add(item);
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
        }
        // 判断查找标题行
        if (!startRead && this.isIndexRow(dataMap)) {
            startRead = true;
            this.getColumnIndex(dataMap);
            titleMap = dataMap;
            for (int key : titleMap.keySet()) {
                String title = titleMap.get(key);
                titleList.add(title);
            }
            titleList.add("标准化品牌");
            titleList.add("标准号型号");
            titleList.add("行号");
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    /**
     * 判断是否包含型号近义词
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
     * @description 获取列索引
     * @param sdada sdada
     */
    private void getColumnIndex(Map<Integer, String> sdada) {
        for (Integer key : sdada.keySet()) {
            if (bomHeadDic.getModleList().contains(sdada.get(key))) {
                log.debug("Modle->" + sdada.get(key));
                modleIndex = key;
            } else if (bomHeadDic.getBrandList().contains(sdada.get(key))) {
                log.debug("Brand->" + sdada.get(key));
                brandIndex = key;
            } else if (bomHeadDic.getQuantityList().contains(sdada.get(key))) {
                log.debug("Quantity->" + sdada.get(key));
                quantityIndex = key;
            } else if (bomHeadDic.getRemarkList().contains(sdada.get(key))) {
                log.debug("Remark->" + sdada.get(key));
                remarkIndex = key;
            }
        }
        ResponseEnum.VALID_ERROR.assertNotNull(modleIndex, "未识别到型号列");
        ResponseEnum.VALID_ERROR.assertNotNull(quantityIndex, "未识别到需求数量列");
    }
}
