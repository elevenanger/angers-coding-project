package com.angers.project.onjava8.functional;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/20 11:07
 * @description : 函数-实现接口
 * lambda 函数只能实现单个抽象方法的接口
 */
public class MultiMethodsFunction {
    static Random random = new Random(93);
    private MultiFunction mf ;
    private int a ;
    private int b ;
    public MultiMethodsFunction() {
        /*
        MultiFunction 函数有两个方法
        但是其中一个是 default
        只有一个抽象方法
        所以可以用 lambda 表达式实现该抽象方法
         */
        this.mf = (x,y) -> {
            a = random.nextInt(x);
            b = random.nextInt(y);
            return a+b;
        };
    }

    public static void main(String[] args) {
        MultiMethodsFunction mf = new MultiMethodsFunction();
        System.out.println(mf.mf.two(100,10000));
        System.out.println(mf.mf.single(100));
    }
}

interface MultiFunction {
    default int single(int i){
        return i*10;
    }
    int two(int a, int b);
}