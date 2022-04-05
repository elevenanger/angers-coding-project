package com.angers.project.onjava8.operator;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/4 10:02
 * @description : java 逻辑运算符
 */
public class LogicalOperator {

    public static void main(String[] args) {
        Random random = new Random(47);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        System.out.println(" i = " + i);
        System.out.println(" j = " + j);
        System.out.println(" i > j is  " + (i>j));
        System.out.println(" i < j is  " + (i<j));
        System.out.println(" i >= j is  " + (i>=j));
        System.out.println(" i <= j is  " + (i<=j));
        System.out.println(" i == j is  " + (i==j));
        System.out.println(" i != j is  " + (i!=j));
        // 只能将逻辑运算符 and(&&) or(||) not(!) 应用于布尔值
        System.out.println(" (i > 10) && ( j > 10 ) is " + ((i > 10) && ( j > 10 )));
        System.out.println(" (i > 10) || ( j > 10 ) is " + ((i > 10) || ( j > 10 )));
    }
}
