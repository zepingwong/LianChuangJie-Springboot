package com.lianchuangjie.lianchuangjie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BomQueryItemDTO {
    /**
     * @description 序号-关联型号序号相同
     */
    @JsonProperty("ItemId")
    private Long itemId;
    /**
     * @description 需求型号
     */
    @JsonProperty("sno")
    private String modle;
    /**
     * @description 品牌
     */
    @JsonProperty("Brand")
    private String brand;
    /**
     * @description 参考价格
     */
    @JsonProperty("PrePrice")
    private BigDecimal prePrice;
    /**
     * @description 询价状态代码
     */
    @JsonProperty("Status")
    private String status;
    /**
     * @description 处理方式
     */
    @JsonProperty("ItemDescStatus")
    private String itemDescStatus;
    /**
     * @description 客户备注 CurRemark
     */
    @JsonProperty("CurRemark")
    private String curRemark;
    /**
     * @description 匹配情况
     */
    @JsonProperty("Match")
    private String match;
    /**
     * @description 失效时间
     */
    @JsonProperty("ExpiredTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接参数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiredTime;
    /**
     * @description 负责采购
     */
    @JsonProperty("SelectedPurchasers")
    private List<String> selectedPurchasers;
    /**
     * @description 重要程度
     */
    @JsonProperty("KeyPoint")
    private String keyPoint;
}
