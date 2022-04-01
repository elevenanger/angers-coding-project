package com.angers.project.annotation;

import com.angers.project.inheritance.Person;
import jdk.nashorn.internal.ir.annotations.Reference;

public @interface BugReport {

    enum Status{ OPEN,CONFIRMED,FIXED,INVALID}

    /*
    注解的元素类型可以是以下几种
     */
    // 基元类型
    boolean showStopper () default false;
    // String
    String assignTo() default "none" ;
    // 类
    Class<?> testCase() default Void.class;
    // 也可以是可选类型参数
    Class<? extends Person> person();
    // 枚举值类型
    Status status() default Status.OPEN;
    // 其它的注解类型
    Reference ref() default @Reference();
    // 以上各种类型的数组
    String [] reportBy();
    Status [] statuses() ;
}
