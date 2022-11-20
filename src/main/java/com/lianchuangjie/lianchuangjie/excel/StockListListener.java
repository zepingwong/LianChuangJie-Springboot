package com.lianchuangjie.lianchuangjie.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.exception.StockList.StockListError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class StockListListener extends AnalysisEventListener<Map<Integer, String>> {
    // 型号列索引
    private Integer modleIndex;
    // 品牌列索引
    private Integer brandIndex;
    // 数量列索引
    private Integer quantityIndex;
    // 备注列索引
    private Integer remarkIndex;
    // 批次索引列
    private Integer yearIndex;
    // 单价索引列
    private Integer priceIndex;
    // 标题行
    private Map<Integer, String> titleMap = new HashMap<>();
    // 子表条目
    private final List<StockListSubEntity> stockListSubEntityList = new ArrayList<>();

    public List<StockListSubEntity> getStockListSubList() {
        return stockListSubEntityList;
    }
    // 读取首行数据
    @Override
    public void invokeHeadMap(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        log.info("解析第一行数据:{}", JSON.toJSONString(dataMap));
        // 如果首行就是索引行
        if (this.isIndexRow(dataMap)) {
            getColumnIndex(dataMap);
            titleMap = dataMap;
        }
    }
    @Override
    public void invoke(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        // 行索引
        int index = analysisContext.readRowHolder().getRowIndex();
        log.debug("解析到第{}行数据：{}", index + 1, dataMap);
        StockListSubEntity stockListSubEntity = new StockListSubEntity();
        stockListSubEntity.setLineNum(Long.parseLong( String.valueOf(index + 1)));
        stockListSubEntity.setBrand(dataMap.get(brandIndex));
        stockListSubEntity.setModle(dataMap.get(modleIndex));
        stockListSubEntity.setYear(dataMap.get(yearIndex));
        stockListSubEntity.setQuantity(BigDecimal.valueOf(Long.parseLong(dataMap.get(quantityIndex))));
        stockListSubEntity.setPrice(BigDecimal.valueOf(Long.parseLong(dataMap.get(priceIndex))));
        if (remarkIndex != null) {
            stockListSubEntity.setRemark(dataMap.get(remarkIndex));
        }
        stockListSubEntityList.add(stockListSubEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
    /**
     * 判断是否包含型号近义词,如果包含则为索引行
     * @param dataRow dataRow
     * @return boolean
     */
    private Boolean isIndexRow(Map<Integer, String> dataRow) {
        return dataRow.containsValue("型号") & dataRow.containsValue("品牌");
    }
    /**
     * @description 解析列索行, 识别型号、品牌、数量列
     * @param rowIndexRow rowIndexRow
     */
    private void getColumnIndex(Map<Integer, String> rowIndexRow) {
        for (Integer key : rowIndexRow.keySet()) {
            if (rowIndexRow.get(key).equals("型号")) {
                log.debug("Modle->" + rowIndexRow.get(key));
                modleIndex = key;
            } else if (rowIndexRow.get(key).equals("品牌")) {
                log.debug("Brand->" + rowIndexRow.get(key));
                brandIndex = key;
            } else if (rowIndexRow.get(key).equals("数量")) {
                log.debug("Quantity->" + rowIndexRow.get(key));
                quantityIndex = key;
            } else if (rowIndexRow.get(key).equals("备注")) {
                log.debug("Remark->" + rowIndexRow.get(key));
                remarkIndex = key;
            } else if (rowIndexRow.get(key).equals("批次")) {
                log.debug("Remark->" + rowIndexRow.get(key));
                yearIndex = key;
            } else if (rowIndexRow.get(key).equals("单价")) {
                log.debug("Remark->" + rowIndexRow.get(key));
                priceIndex = key;
            }
        }
        StockListError.ISNULL.assertNotNull(modleIndex, "未识别到型号列");
        StockListError.ISNULL.assertNotNull(brandIndex, "未识别到品牌列");
        StockListError.ISNULL.assertNotNull(quantityIndex, "未识别到数量列");
        StockListError.ISNULL.assertNotNull(priceIndex, "未识别到单价列");
        StockListError.ISNULL.assertNotNull(yearIndex, "未识别到批次列");
    }
}
