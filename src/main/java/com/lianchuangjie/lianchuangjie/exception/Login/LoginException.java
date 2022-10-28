package com.lianchuangjie.lianchuangjie.exception.Login;

import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

public class LoginException extends BaseException {

    public LoginException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }
    public LoginException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
