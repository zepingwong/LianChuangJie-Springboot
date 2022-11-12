package com.lianchuangjie.lianchuangjie.exception.Token;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TokenError implements TokenExceptionAssert{
    ISNULL(8001, "token不能为空"),
    TOKEN_SIGNATURE(8002, "token签名错误"),
    TOKEN_EXPIRED(8003, "token已过期"),
    TOKEN_ALGORITHM_MISMATCH(8004, "token算法错误"),
    TOKEN_ERROR(8005, "token错误");

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
