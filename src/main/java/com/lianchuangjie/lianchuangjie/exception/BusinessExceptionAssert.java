package com.lianchuangjie.lianchuangjie.exception;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author WANG Zeping
 * @date 2022-07-20 11:20
 * @description 定义BusinessExceptionAssert同时实现Assert判断逻辑和枚举类区分不同业务异常逻辑
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg, t);
    }

}

