package com.angers.project.onjava8.housekeeping;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/8 16:06
 * @description : 基元数值类型数组
 */
public class ArraysOfPrimitives {

    public static void main(String[] args) {
        System.out.println("a1 start ...");
        int [] a1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(a1));
        System.out.println("a2 start ...");
        int [] a2 = new int[5];
        System.out.println(Arrays.toString(a2));
        System.out.println("a3 start ...");
        int [] a3;
        a3 = a1; // 这里对 a3 进行初始化，用 a1 给 a3 赋值，其实是进行了引用的拷贝，a1 和 a3 指向同一个数组
        for (int i = 0; i < a3.length; i++) {
            a3 [i] += 1;
        }
        System.out.println(Arrays.toString(a3));
        System.out.println("a1 start again ...");
        System.out.println(Arrays.toString(a1));
        /*
        output:
        a1 start ...
        [1, 2, 3, 4, 5]
        a2 start ...
        [0, 0, 0, 0, 0]
        a3 start ...
        [2, 3, 4, 5, 6]
        a1 start again ...
        [2, 3, 4, 5, 6]
         */
    }
}