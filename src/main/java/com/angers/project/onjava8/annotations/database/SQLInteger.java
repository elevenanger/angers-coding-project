package com.angers.project.onjava8.annotations.database;

/**
 * @author : liuanglin
 * @date : 2022/5/13 14:17
 * @description : 注解-数据库注解
 */
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}
