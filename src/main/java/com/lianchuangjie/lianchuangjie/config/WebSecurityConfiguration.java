package com.lianchuangjie.lianchuangjie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @description Spring Security 配置
 * @date 2022-06-10
 * @author WANG Zeping
 * @email zepingwong@gmail.com
 */
@Configuration
public class WebSecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 放行所有请求
        http.authorizeRequests().anyRequest().permitAll();
        // 必须禁用 csrf，否则导致 POST、PUT 请求 403
        http.csrf().disable();
        return http.build();
    }
}