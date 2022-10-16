package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 有效货源YTab
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabEnquiryAvailableVO {
    // 报价单编号
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 报价单内部行号
    @JsonProperty("BaseLine")
    private Long baseLine;
    // 货源类型
    @JsonProperty("Resource")
    private String resource;
    // 报价型号
    @JsonProperty("U_QuoModle")
    private String uQuoModle;
    // 报价品牌
    @JsonProperty("U_QuoBrand")
    private String uQuoBrand;
    // 报价交期 T_ICIN1.U_QuoDelivery
    @JsonProperty("U_QuoDelivery")
    private String uQuoDelivery;
    // 报价批次 T_ICIN1.U_QuoYear
    @JsonProperty("U_QuoYear")
    private String uQuoYear;
    // 报价数量 T_ICIN1.U_QuoQty
    @JsonProperty("U_QuoQty")
    private BigDecimal uQuoQty = BigDecimal.valueOf(0);
    // 质检标准 T_ICIN1.U_QCDesc
    @JsonProperty("U_QCDesc")
    private String uQCDesc;
    // 供应商等级 T_ICIN1.U_QuoLevel
    @JsonProperty("U_QuoLevel")
    private String uQuoLevel;
    // 采购部门名称/货源 T_OCDP.Name
    @JsonProperty("DeptName")
    private String deptName;
    // 引用采购报价的采购员姓名 T_OUSI.UserName
    @JsonProperty("BuyerName")
    private String buyerName;
    // 用采购报价的采购员编号 T_ICIN1.U_Buyer
    @JsonProperty("U_Buyer")
    private Long uBuyer;
    // 报价日期 T_ICIN1.U_QuoDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("U_QuoDate")
    private Date uQuoDate;
    // QuoState 是否询价
    @JsonProperty("QuoState")
    private String quoState;
}
