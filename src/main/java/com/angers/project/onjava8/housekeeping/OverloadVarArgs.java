package com.angers.project.onjava8.housekeeping;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/9 12:00
 * @description : 注意对于变量参数列表方法的重载
 */
public class OverloadVarArgs {

    public static void main(String[] args) {
        /*
        编译器使用自动装箱的机制匹配重载的方法
        调用最相符的方法
        但是如果不带任何参数，编译器则无法确定可以调用哪个方法
         */
        CommonUtils.printDivideLineStart("test1");
        Test1.f(1,2,3,4);
        Test1.f('a','b','c','d');
        Test1.f(100L,213213L);
        CommonUtils.printDivideLineEnd("test1");

        /* output
        Test1.f(Integer ... args)
        1 2 3 4
        Test1.f(Character ... args)
        a b c d
        Test1.f(Long ... args)
        100 213213
         */

        /*
        Test2.f(1,'a');
        Test2.f('g','a');
        会报错，对象引用不明确
         */

        CommonUtils.printDivideLineStart("Test3");
        Test3.f(1,'a');
        Test3.f('g','a');
        CommonUtils.printDivideLineEnd("Test3");

        /* Test3 output
        Test3.f(float i,Character ... args)
        i = 1.0
        a
        Test3.f(char c,Character ... args)
        c = g
        a
         */

        /*
        总结：
        在所有重载方法中，只使用一种变量参数列表版本
        或者避免在重载方法中使用变量参数列表
         */
    }

}

class Test1 {
    static void f(Integer ... args){
        System.out.println("Test1.f(Integer ... args) ");
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

    static void f(Character ... args){
        System.out.println("Test1.f(Character ... args) ");
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

    static void f(Long ... args){
        System.out.println("Test1.f(Long ... args) ");
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }
}

class Test2 {
    static void f(float i , Character ... args){
        System.out.println("Test2.f(float i , Character ... args)");
        System.out.println("i = " + i);
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

    static void f(Character ... args) {
        System.out.println("Test2.f(Character ... args)");
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

}

class Test3 {
    static void f(float i,Character ... args){
        System.out.println();
        System.out.println("Test3.f(float i,Character ... args)");
        System.out.println("i = " + i);
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
    }

    static void f(char c,Character ... args){
        System.out.println();
        System.out.println("Test3.f(char c,Character ... args)");
        System.out.println("c = " + c);
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
    }

}
