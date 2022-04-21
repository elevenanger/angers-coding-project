package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 16:36
 * @description : 函数-函数式接口注解
 * 每个函数式接口都只有一个抽象方法
 */
public class FunctionalAnnotation {
    public String goodBye (String arg){
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional functional = fa::goodBye; // 传递 fa::goodBye 方法
        System.out.println(functional.goodbye("functional"));
        FunctionalNoAnn functionalNoAnn = fa::goodBye;
        System.out.println(functionalNoAnn.goodbye("functionalNoAnn"));
        Functional fl = arg -> "GoodBye, functional" + arg; // 使用 lambda 表达式实现 goodbye 方法，将函数赋值给方法
        System.out.println(fl.goodbye(" "));
        FunctionalNoAnn fla = arg -> "GoodBye, functionalNoAnn" + arg;
        System.out.println(fla.goodbye(" "));
        /*
        Functional 和 FunctionalNoAnn 接口都只有一个抽象方法，都符合 @FunctionalInterface 注解的定义
        在使用上完全一致
        @FunctionalInterface 是检查注解，检查接口是否符合  @FunctionalInterface 规则
        @FunctionalInterface 接口也称为单一抽象方法类型
         */
    }
}

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
    default  void good(String a){
        System.out.println(a);
    }
}

interface FunctionalNoAnn{
    String goodbye(String arg);
}
