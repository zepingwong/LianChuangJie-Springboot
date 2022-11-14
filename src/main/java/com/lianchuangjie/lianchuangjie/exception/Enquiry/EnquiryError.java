package com.lianchuangjie.lianchuangjie.exception.Enquiry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnquiryError implements EnquiryExceptionAssert {
    SAVE_ERROR(8002,"保存失败"),
    ISNULL(8001, "{0}"),
    HAS_NO_AUTHENTICATION(403, "权限错误.{0}"),
    VALID_ERROR(8000, "{0}"),;

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
