package com.lianchuangjie.lianchuangjie.exception.Login;

import com.lianchuangjie.lianchuangjie.exception.Assert;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

import java.text.MessageFormat;

public interface LoginExceptionAssert extends IResponseEnum, Assert {
    @Override
    default LoginException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new LoginException(this, args, msg);
    }

    @Override
    default LoginException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new LoginException(this, args, msg, t);
    }
}
