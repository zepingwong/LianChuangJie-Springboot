package com.lianchuangjie.lianchuangjie.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("set")
    public String setValue() {
        String key = "StockPrice";
        String value = "1";
        stringRedisTemplate.opsForValue().set(key, value);
        return "set succ";
    }

    @GetMapping("get")
    public String getValue() {
        String key = "username";
        return stringRedisTemplate.opsForValue().get(key);
    }
}