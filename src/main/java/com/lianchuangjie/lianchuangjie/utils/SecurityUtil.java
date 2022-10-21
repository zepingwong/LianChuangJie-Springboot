package com.lianchuangjie.lianchuangjie.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {
    /**
     * @description 生成BCryptPasswordEncoder密码
     * @param password 密码
     * @return 加密字符串
     */
    public static String encodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * @description 判断密码是否相同
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static Boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
