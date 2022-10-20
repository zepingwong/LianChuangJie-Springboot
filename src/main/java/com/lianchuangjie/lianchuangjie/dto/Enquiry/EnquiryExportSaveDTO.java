package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquiryExportSaveDTO {
    // 单据编号
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 主题
    @JsonProperty("Subject")
    private String subject;
    /**
     * @description 从
     */
    @JsonProperty("U_FromCompany")
    private String uFromCompany;
    /**
     * @description 发件人姓名
     */
    @JsonProperty("U_SenderName")
    private String uSenderName;
    /**
     * @description 发件人电话
     */
    @JsonProperty("U_SenderTel")
    private String uSenderTel;
    /**
     * @description 收件人姓名
     */
    @JsonProperty("U_RecipientName")
    private String uRecipientName;
    /**
     * @description 收件人电话
     */
    @JsonProperty("U_RecipientTel")
    private String uRecipientTel;
    // 交易地点
    @JsonProperty("U_TransaPlace")
    private String uTransaPlace;
    // 运费支付
    @JsonProperty("U_FreightPayment")
    private String uFreightPayment;
    // 付款方式
    @JsonProperty("U_PaymentMethod")
    private String uPaymentMethod;
}
