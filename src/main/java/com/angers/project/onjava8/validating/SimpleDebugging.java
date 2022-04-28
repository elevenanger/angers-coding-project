package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/27 16:39
 * @description : 校验-简单的 debug 程序
 */
public class SimpleDebugging {
    private static void f1(){
        System.out.println("f1");
        f2();
    }
    private static void f2(){
        System.out.println("f2");
        f3();
    }
    private static void f3(){
        System.out.println("f3");
        int j = 1;
        j--;
        int i = 5/j;
    }

    public static void main(String[] args) {
        f1();
    }
}
