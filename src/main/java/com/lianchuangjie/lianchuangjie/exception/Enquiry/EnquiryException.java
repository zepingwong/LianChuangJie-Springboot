package com.lianchuangjie.lianchuangjie.exception.Enquiry;

import com.lianchuangjie.lianchuangjie.exception.BaseException;
import com.lianchuangjie.lianchuangjie.exception.IResponseEnum;

public class EnquiryException extends BaseException {

    public EnquiryException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }
    public EnquiryException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
