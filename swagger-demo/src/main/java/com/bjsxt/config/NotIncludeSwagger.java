package com.bjsxt.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author lvyelanshan
 * @create 2019-11-23 10:31
 */
@Target({ElementType.METHOD}) //表示该注解作用在方法上
@Retention(RetentionPolicy.RUNTIME) //表示该注解是在运行时被解析的
public @interface NotIncludeSwagger {
}
