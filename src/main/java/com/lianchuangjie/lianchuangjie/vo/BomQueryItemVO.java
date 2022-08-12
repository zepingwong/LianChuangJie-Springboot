package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description 一行BOM单解析匹配结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomQueryItemVO {
    /**
     * @description 序号-关联型号序号相同
     */
    @JsonProperty("Id")
    private Long id;
    /**
     * @description 行号
     */
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 型号
     */
    @JsonProperty("Modle")
    private String Modle;
    /**
     * @description 关联型号
     */
    @JsonProperty("sno")
    private String sno;
    /**
     * @description 品牌
     */
    @JsonProperty("Brand")
    private String Brand;
    /**
     * @description 匹配品牌
     */
    @JsonProperty("QuoBrand")
    private String QuoBrand;
    /**
     * @description 达标情况
     */
    @JsonProperty("TAG")
    private String TAG;
    /**
     * @description 需求数量
     */
    @JsonProperty("DemandQty")
    private BigDecimal DemandQty;
    /**
     * @description 客户备注 CurRemark
     */
    @JsonProperty("CurRemark")
    private String CurRemark;
    /**
     * @description 库存数量
     */
    @JsonProperty("Quantity")
    private BigDecimal Quantity;
    /**
     * @description 参考价格
     */
    @JsonProperty("PrePrice")
    private BigDecimal PrePrice;
    /**
     * @description 询价状态代码
     */
    @JsonProperty("Status")
    private String Status;
    /**
     * @description 处理方式
     */

    @JsonProperty("ItemDescStatus")
    private String ItemDescStatus;
    public String getItemDescStatus() {
        switch (Status) {
            case "B" : {
                return "采购报价";
            }
            case "C": {
                return "直接报价";
            }
            case "D": {
                return "暂不处理";
            }
            case "E": {
                return "云汉报价";
            }
            default:{
                return null;
            }
        }
    }
    /**
     * @description 总价
     */
    @JsonProperty("TotalPrice")
    private BigDecimal TotalPrice;
    /**
     * @description ECCN
     */
    @JsonProperty("ECCN")
    private String eccn;
    /**
     * @description 采购
     */
    @JsonProperty("Buyer")
    private String Buyer;
    /**
     * @description 负责采购
     */
    @JsonProperty("Purchaser")
    private List<EnquiryBuyerItemVO> purchaser;
    public List<EnquiryBuyerItemVO> getPurchaser() {
        if (Buyer == null) return null;
        List<EnquiryBuyerItemVO> list = new ArrayList<>();
        String[] buyerStrList = Buyer.split(",");
        for (String buyerStr : buyerStrList) {
            String[] buyerObj = buyerStr.split(":");
            EnquiryBuyerItemVO buyer = new EnquiryBuyerItemVO(Long.parseLong(buyerObj[0]), buyerObj[1]);
            list.add(buyer);
        }
        return list;
    }
    /**
     * @description 匹配情况
     */
    @JsonProperty("Match")
    private String Match;
    /**
     * @description spq
     */
    @JsonProperty("spq")
    private String spq;
    /**
     * @description 失效时间
     */
    @JsonProperty("ExpiredTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 接参数
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date expiredTime;
    /**
     * @description 负责采购
     */
    @JsonProperty("SelectedPurchasers")
    private List<String> SelectedPurchasers;
    /**
     * @description 重要程度
     */
    @JsonProperty("KeyPoint")
    private String keyPoint;
}
