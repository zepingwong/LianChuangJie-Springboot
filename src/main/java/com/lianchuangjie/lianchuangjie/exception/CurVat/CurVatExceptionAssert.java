package com.lianchuangjie.lianchuangjie.exception.CurVat;

import com.lianchuangjie.lianchuangjie.exception.Assert;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

import java.text.MessageFormat;

public interface CurVatExceptionAssert extends IResponseEnum, Assert {
    @Override
    default CurVatException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new CurVatException(this, args, msg);
    }

    @Override
    default CurVatException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new CurVatException(this, args, msg, t);
    }
}
