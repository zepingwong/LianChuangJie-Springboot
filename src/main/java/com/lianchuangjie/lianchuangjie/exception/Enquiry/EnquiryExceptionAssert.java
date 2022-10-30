package com.lianchuangjie.lianchuangjie.exception.Enquiry;

import com.lianchuangjie.lianchuangjie.exception.Assert;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;
import com.lianchuangjie.lianchuangjie.exception.Login.LoginException;

import java.text.MessageFormat;

public interface EnquiryExceptionAssert extends IResponseEnum, Assert {
    @Override
    default EnquiryException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new EnquiryException(this, args, msg);
    }

    @Override
    default EnquiryException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new EnquiryException(this, args, msg, t);
    }
}
