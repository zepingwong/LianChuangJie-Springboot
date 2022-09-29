package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryExportHeadVO {
    // 编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    /**
     * @description 主题
     */
    @JsonProperty("Subject")
    private String subject;
    /**
     * @description 从
     */
    @JsonProperty("U_FromCompany")
    private String ufromCompany;
    /**
     * @description 致客户名称
     */
    @JsonProperty("CardName")
    private String cardName;
    /**
     * @description 发件人姓名
     */
    @JsonProperty("U_SenderName")
    private String usenderName;
    /**
     * @description 发件人电话
     */
    @JsonProperty("U_SenderTel")
    private String usenderTel;
    /**
     * @description 收件人姓名
     */
    @JsonProperty("U_RecipientName")
    private String urecipientName;
    /**
     * @description 收件人电话
     */
    @JsonProperty("U_RecipientTel")
    private String urecipientTel;
    // 交易地点
    @JsonProperty("U_TransaPlace")
    private String utransaPlace;
    // 运费支付
    @JsonProperty("U_FreightPayment")
    private String ufreightPayment;
    // 税率
    @JsonProperty("VatRate")
    private BigDecimal vatRate;
    // 有效期
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("ExpDate")
    private Date expDate;
    // 付款方式
    @JsonProperty("U_PaymentMethod")
    private String upaymentMethod;
    // 需求货币
    @JsonProperty("U_DocCur")
    private String udocCur;

    @JsonProperty("DateNow")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateNow = new Date();
}
