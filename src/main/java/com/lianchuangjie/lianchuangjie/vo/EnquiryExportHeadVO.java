package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EnquiryExportHeadVO {
    /**
     * @description 主题
     */
    @JsonProperty("Subject")
    private String subject;
    /**
     * @description 从
     */
    @JsonProperty("From")
    private String from = "深圳市联创杰科技有限公司";
    /**
     * @description 致
     */
    @JsonProperty("To")
    private String to;
    /**
     * @description 发件人姓名
     */
    @JsonProperty("SenderName")
    private String senderName;
    /**
     * @description 发件人电话
     */
    @JsonProperty("SenderTel")
    private String senderTel;
    /**
     * @description 收件人姓名
     */
    @JsonProperty("RecipientName")
    private String recipientName;
    /**
     * @description 收件人电话
     */
    @JsonProperty("RecipientTel")
    private String recipientTel;
}
