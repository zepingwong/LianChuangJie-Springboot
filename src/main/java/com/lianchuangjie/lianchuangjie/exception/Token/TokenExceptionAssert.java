package com.lianchuangjie.lianchuangjie.exception.Token;

import com.lianchuangjie.lianchuangjie.exception.Assert;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;
import com.lianchuangjie.lianchuangjie.exception.Login.LoginException;

import java.text.MessageFormat;

public interface TokenExceptionAssert extends IResponseEnum, Assert {
    @Override
    default TokenException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new TokenException(this, args, msg);
    }

    @Override
    default TokenException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new TokenException(this, args, msg, t);
    }
}
