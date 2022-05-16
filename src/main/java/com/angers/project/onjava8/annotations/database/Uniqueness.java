package com.angers.project.onjava8.annotations.database;

/**
 * @author : liuanglin
 * @date : 2022/5/13 14:24
 * @description :注解-数据库-唯一性
 */
public @interface Uniqueness {
    /**
     * 在注解中嵌套注解
     * @return Constraints 数据库约束
     */
    Constraints constraints() default @Constraints(unique = true);
}
