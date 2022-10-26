package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 询价匹配结果
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryMatchItemVO {
    // 树形数组索引-客户原需求ParentId为0,关联型号ParentId为客户需求的LineNum
    @JsonProperty("ItemId")
    private Long itemId;
    /**
     * @description 行号
     */
    @JsonProperty("LineNum")
    private Long lineNum;
    /**
     * @description 型号
     */
    @JsonProperty("Modle")
    private String modle;
    /**
     * @description 关联型号
     */
    @JsonProperty("sno")
    private String sno;
    /**
     * @description 品牌
     */
    @JsonProperty("Brand")
    private String brand;
    /**
     * @description 匹配品牌
     */
    @JsonProperty("QuoBrand")
    private String QuoBrand;
    /**
     * @description 打标情况
     */
    @JsonProperty("TAG")
    private String tag;
    /**
     * @description 需求数量
     */
    @JsonProperty("DemandQty")
    private BigDecimal demandQty;
    /**
     * @description 客户备注 CurRemark
     */
    @JsonProperty("CurRemark")
    private String curRemark;
    /**
     * @description 库存数量
     */
    @JsonProperty("Quantity")
    private BigDecimal quantity;
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

    public String getItemDescStatus() {
        switch (status) {
            case "B": {
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
            default: {
                return null;
            }
        }
    }

    /**
     * @description 总价
     */
    @JsonProperty("TotalPrice")
    private BigDecimal totalPrice;
    /**
     * @description ECCN
     */
    @JsonProperty("ECCN")
    private String eccn;
    /**
     * @description 采购
     */
    @JsonProperty("Buyer")
    private String buyer;
    /**
     * @description 负责采购
     */
    @JsonProperty("Purchaser")
    private List<EnquiryBuyerItemVO> purchaser;

    public List<EnquiryBuyerItemVO> getPurchaser() {
        if (buyer == null | Objects.equals(buyer, "")) return new ArrayList<>();
        List<EnquiryBuyerItemVO> list = new ArrayList<>();
        String[] buyerStrList = buyer.split(",");
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
    private String match;
    /**
     * @description spq
     */
    @JsonProperty("spq")
    private String spq;
    // 关联型号折叠
    @JsonProperty("children")
    List<EnquiryMatchItemVO> children = new ArrayList<>();
}
