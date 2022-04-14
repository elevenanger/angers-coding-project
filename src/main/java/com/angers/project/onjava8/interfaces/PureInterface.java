package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 15:37
 * @description : Java 8 之前的接口定义
 * 接口通常暗示“类的类型”或形容词
 * 如 Runnable 或 Serializable
 * 而抽象类通常是类层次结构的一部分
 * 是“事物的类型”，如 String 或 ActionHero
 */
public interface PureInterface {
    // 接口中可以定义域，但是域是隐式的 static 和 final
    String DESC = "PURE_INTERFACE";
    /*
    Java 8 之前接口定义
    只允许 abstract 方法
    不需要声明 abstract
    因为在接口中的方法都是 abstract 的
    interface 关键字定义了一个完全 abstract 类，所有的方法都没有实现逻辑
    接口表达的是一种类型的概念，而不是具体的实现
     */
    int m1();
    int m2();
    int m3();
}