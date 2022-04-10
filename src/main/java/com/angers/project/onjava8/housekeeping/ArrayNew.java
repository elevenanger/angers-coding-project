package com.angers.project.onjava8.housekeeping;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/9 09:29
 * @description : 创建新的数组，动态生成数组长度
 */
public class ArrayNew {
    public static void main(String[] args) {
        Random random = new Random(93);
        int [] a = new int[random.nextInt(91)];
        a[0] = 100;
        System.out.println("Array's length = " + a.length);
        System.out.println(Arrays.toString(a));
    }
}
