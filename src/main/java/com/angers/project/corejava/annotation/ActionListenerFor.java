package com.angers.project.corejava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解通过注解接口 @interface 来定义
 * 所有的注解接口都隐式继承 java.lang.annotation.Annotation 接口
 * 这个接口是普通接口，不是注解接口
 * 注解接口无法再被继承
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {

    /**
     * 注解中的元素（方法）定义形式：
     * 1、 type elementName();
     * 2、 type elementName() default defaultValue;
     * 注解的方法没有参数，也没有 throws 语句
     * 它们不能是 static 或者 default 方法
     * 不能有形参
     * @return 名称
     */
    String source() default "";
}
