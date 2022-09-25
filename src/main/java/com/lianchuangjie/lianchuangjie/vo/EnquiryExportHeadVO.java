package com.lianchuangjie.lianchuangjie.vo;

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
    private String subject;
    /**
     * @description 从
     */
    private String from = "深圳市联创杰科技有限公司";
    /**
     * @description 致
     */
    private String to;
    /**
     * @description 发件人姓名
     */
    private String senderName;
    /**
     * @description 发件人电话
     */
    private String senderTel;
    /**
     * @description 收件人姓名
     */
    private String recipientName;
    /**
     * @description 收件人电话
     */
    private String recipientTel;
}
