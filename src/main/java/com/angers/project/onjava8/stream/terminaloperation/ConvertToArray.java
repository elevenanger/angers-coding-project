package com.angers.project.onjava8.stream.terminaloperation;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/24 16:05
 * @description : 流-将流转换成数组
 */
public class ConvertToArray {
    public static void main(String[] args) {
        Object [] ints = new Random(93)
                .ints(100,9999)
                .limit(20)
                .boxed()
                .toArray();
        for (Object anInt : ints) {
            System.out.println(anInt);
        }
    }
}
