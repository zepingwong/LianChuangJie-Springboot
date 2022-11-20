package com.lianchuangjie.lianchuangjie.exception.StockList;

import com.lianchuangjie.lianchuangjie.exception.Assert;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

import java.text.MessageFormat;

public interface StockListExceptionAssert extends IResponseEnum, Assert {
    @Override
    default StockListException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new StockListException(this, args, msg);
    }

    @Override
    default StockListException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new StockListException(this, args, msg, t);
    }
}
