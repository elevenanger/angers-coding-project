package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/4 17:54
 * @description : 指数符号 e ：10的次方
 */
public class Exponents {

    public static void main(String[] args) {
        float expFloat = 1.93e-12f; // 也可以使用大写的 E
        System.out.println(expFloat);
        double expDouble1 = 1.39e12d;
        System.out.println(expDouble1);
        double expDouble2 = 1.39e12; // d 可以省略
        System.out.println(expDouble2);
    }
}
