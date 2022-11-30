package com.lianchuangjie.lianchuangjie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncTaskConfig {
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(10);
        // 线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(1800);
        // 最大线程数
        executor.setMaxPoolSize(1000);
        // 队列最大长度
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }
}