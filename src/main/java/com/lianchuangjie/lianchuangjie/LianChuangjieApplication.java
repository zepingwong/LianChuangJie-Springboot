package com.lianchuangjie.lianchuangjie;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan("com.lianchuangjie.lianchuangjie.mapper")
public class LianChuangjieApplication {
    public static void main(String[] args) {
        SpringApplication.run(LianChuangjieApplication.class, args);
    }
}
