package com.lianchuangjie.lianchuangjie.exception;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.Objects;

public interface Assert {
    /**
     * @description 创建异常
     * @param args 异常参数
     * @return 自定义异常
     */
    BaseException newException(Object... args);
    BaseException newException(Throwable t, Object... args);
    /**
     * @description 断言对象obj非空。如果对象obj为空，则抛出异常
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException((Object) null);
        }
    }
    /**
     * @description 断言对象obj非空。如果对象obj为空，则抛出异常
     * @description 异常信息message支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw newException(args);
        }
    }
    /**
     * 断言字符串不为 empty 不为 null
     */
    default void assertNullOrEmpty(String str, Object... args) {
        if (str == null) {
            throw newException(args);
        }
        if (StringUtils.isEmpty(str)) {
            throw newException(args);
        }
    }
    /**
     * @description 断言两个字符串是否相等。如果不相等，则抛出异常
     * @description 异常信息message支持传递参数方式，避免在判断之前进行字符串拼接操作
     * @param str1 待判断对象
     * @param str2 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotEqual(String str1, String str2, Object... args) {
        if (!Objects.equals(str1, str2)) {
            throw newException(args);
        }
    }
    /**
     * 断言True Or False，结果为true时抛出异常
     */
    default void assertIsTrue(Boolean val, Object... args) {
        if (val) {
            throw newException(args);
        }
    }
    /**
     * 断言True Or False，结果为true时抛出异常
     */
    default void assertIsFalse(Boolean val, Object... args) {
        if (!val) {
            throw newException(args);
        }
    }
}
