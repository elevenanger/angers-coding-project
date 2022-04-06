package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/5 20:53
 * @description : 对数值进行运算时，尤其是加法或者乘法的扩大运算可能会溢出当前运算的数值类型
 */
public class Overflow {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        int bigger = max * 2;
        System.out.println(bigger);
        long biggerL = (long) max * 2 ;
        System.out.println(biggerL);
    }
}
