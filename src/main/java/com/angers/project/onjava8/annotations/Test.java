package com.angers.project.onjava8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : liuanglin
 * @date : 2022/5/13 08:33
 * @description : 注解-定义注解的格式
 */

/**
 * @Target @Retention 都是元数据接口，定义注解的作用域和在什么时候可用
 * 注解中可以有指定值的元素，也可以不包含任何元素
 * 这种不包含任何元素的注解称之为标记注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
