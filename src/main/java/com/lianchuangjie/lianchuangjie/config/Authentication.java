package com.lianchuangjie.lianchuangjie.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD}) // 用在方法类上
@Retention(RetentionPolicy.RUNTIME)  // 保留在程序运行期间
@Documented
public @interface Authentication {
    boolean buyer() default false; // 采购员

    boolean sale() default false; // 销售员
    boolean saleAssist() default false; // 销售助理
}
