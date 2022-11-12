package com.lianchuangjie.lianchuangjie.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        setString(key, value, null);
    }

    public void setString(String key, String value, Long timeOut) {
        stringRedisTemplate.opsForValue().set(key, value);
        if (timeOut != null) {
            stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    public Boolean removeString(String token) {
        stringRedisTemplate.delete(token);
        return true;
    }
}
