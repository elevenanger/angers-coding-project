package com.angers.project.onjava8.housekeeping;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/9 09:44
 * @description : 创建对象数组
 */
public class ArrayClassObj {

    public static void main(String[] args) {
        Random random = new Random(93);
        Integer [] a = new Integer[random.nextInt(99)];
        System.out.println("Arrays of Object's length = " + a.length);
        for (int i = 0; i < a.length; i++) {
            a [i] = random.nextInt(1993);
        }
        System.out.println(Arrays.toString(a));
    }
}