package com.angers.project.onjava8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : liuanglin
 * @date : 2022/5/13 08:40
 * @description :注解-用户用例
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    // 注解接口中定义的方法，和接口方法一样，使用该注解需要实现该方法并符合方法签名
    int id() default -1;
    // 用户永林描述，默认值为 nothing 使用接口没有实现该方法则会赋值为默认值
    String desc() default "";
    /*
    注解中的元素值不允许为null
    无论是使用注解时的赋值
    还是默认值
    一般可以使用 -1 空字符串 "" 作为替代
     */
}
