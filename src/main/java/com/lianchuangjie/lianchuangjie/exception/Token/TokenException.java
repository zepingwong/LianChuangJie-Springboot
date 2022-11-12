package com.lianchuangjie.lianchuangjie.exception.Token;

import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

public class TokenException extends BaseException {
    public TokenException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }
    public TokenException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
