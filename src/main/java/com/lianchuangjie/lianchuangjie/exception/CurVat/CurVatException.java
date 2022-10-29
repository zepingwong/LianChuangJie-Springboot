package com.lianchuangjie.lianchuangjie.exception.CurVat;

import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

public class CurVatException extends BaseException {
    public CurVatException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }
    public CurVatException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
