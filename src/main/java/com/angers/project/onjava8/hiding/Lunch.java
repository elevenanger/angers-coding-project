package com.angers.project.onjava8.hiding;

import com.angers.project.onjava8.common.CommonUtils;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/11 08:46
 * @description : 演示 class 修饰符
 */
public class Lunch {
    private Lunch(){
        CommonUtils.printDivideLineStart("Have a lunch.");
        Soup1.makeSoup1();
        Soup2.makeSoup2().f();
        CommonUtils.printDivideLineEnd("Nice lunch!");
    }

    public static Lunch haveALunch(){
        return new Lunch();
    }
    public static void main(String[] args) {
        Lunch lunch = new Lunch();
    }
}

/*
常规类的访问权限只能是 public 或者 默认的 package
 */
class Soup1 {
    /**
     * 防止他人直接创建类的对象
     * 将所有的构造函数都设为 private
     * 在内部定义一个 static 成员
     * 通过 static 成员创建对象
     * 这种做法可以在创建类的对象之前执行额外的操作
     */
    private Soup1(){
        System.out.println("Soup1");
    }
    public static Soup1 makeSoup1(){
        return new Soup1();
    }
}

class Soup2 {
    private Soup2(){
        System.out.println(LocalDateTime.now() + " Soup2");
    }

    /*
    Soup2 使用了一种设计模式
    这种设计模式称为 单例
    private static Soup2 sp2
    只允许创建一个 Soup2 对象
    除了通过 public static Soup2 makeSoup2() 方法
    没有其它的方式可以访问该对象
     */
    private static Soup2 sp2 = new Soup2();
    public static Soup2 makeSoup2(){
        return sp2;
    }
    public void f(){
        Random random = new Random(93);
        System.out.println(random.nextBoolean() + "Soup2.f()");
    }
}