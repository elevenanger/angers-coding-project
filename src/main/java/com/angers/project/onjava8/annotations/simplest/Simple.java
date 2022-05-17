package com.angers.project.onjava8.annotations.simplest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : liuanglin
 * @date : 2022/5/16 08:34
 * @description :注解-简单注解
 * source 表示不需要编译器处理的注解，唯一能处理该注解的客户端是 javac
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.METHOD,
ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,
ElementType.PACKAGE,ElementType.FIELD,
ElementType.LOCAL_VARIABLE})
public @interface Simple {
    String value() default "-default-";
}
