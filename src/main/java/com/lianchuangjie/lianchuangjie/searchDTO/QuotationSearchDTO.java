package com.lianchuangjie.lianchuangjie.searchDTO;

import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuotationSearchDTO {
    /**
     * @description 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer page;
    /**
     * @description 每页显示数量
     * @maxValue 50
     */
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页最多显示50条数据")
    private Integer size;
    /**
     * @description 采购员编号
     */
    private Long uBuyer;
    public void setUBuyer(Long ownerCode) {
        this.uBuyer = ownerCode != null ? ownerCode : SessionUtil.getUserSign();
    }
    /**
     * @description 需求型号 Modle
     */
    private String modle;
    /**
     * @description 品牌 Brand
     */
    private String brand;
    /**
     * @description 状态 U_Status
     */
    private String uStatus;
    /**
     * @description 销售部门编号
     */
    private String uDeptCode;
    /**
     * @description 销售员
     */
    private Long ownerCode;
    /**
     * @description 询价开始日期
     */
    private Date inquiryDateStart;
    public void setInquiryDateStart(Date inquiryDateStart) {
        this.inquiryDateStart = inquiryDateStart;
    }
    /**
     * @description 询价结束日期
     */
    private Date inquiryDateEnd;
    public void setInquiryDateEnd(Date inquiryDateEnd) {
        this.inquiryDateEnd = inquiryDateEnd;
    }
}
