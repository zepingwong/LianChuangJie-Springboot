package com.lianchuangjie.lianchuangjie.utils.validate;

import java.util.regex.Pattern;

public class ValidateUtil {
    /**
     * @description 正则匹配是否正整数
     * @param str 需要判断的str
     * @return boolean
     */
    public static boolean isInteger(String str) {
        final Pattern pattern = Pattern.compile("^[-+]?\\d*$");
        return pattern.matcher(str).matches();
    }
}
