package com.lianchuangjie.lianchuangjie.exception.Enquiry;

import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryExceptionAssert;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnquiryError implements EnquiryExceptionAssert {
    SAVE_ERROR(8002,"保存失败"),;

    private final Integer code;
    private final String message;


    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
