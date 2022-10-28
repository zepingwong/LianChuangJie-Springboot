package com.lianchuangjie.lianchuangjie.exception.Login;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LoginError implements LoginExceptionAssert{
    PASSWORD_ERROR(8002,"{0}"),
    ISNULL(8001, "{0}"),;

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
