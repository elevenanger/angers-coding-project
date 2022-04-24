package com.angers.project.onjava8.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/23 10:18
 * @description : 流 Stream.iterate() 方法
 * 第一个参数 seed 为初始值
 * 第二个参数将初始值传给方法
 * 每次方法执行的结果都会被添加到 Stream 中
 * 并将结果赋值给 seed 用于下一次的运算
 */
public class StreamIterate {
    private static int x = 1;

    private static Random random = new Random(93);
    static Stream<Integer> fibonacci (){
        return  Stream.iterate( 0, integer -> {
            int result = x + integer;
            x = integer ;
            return result;
        });
    }

    static Stream<String>  balaSong() {
        return Stream.iterate("bala",s -> {
            return s + " bala";
        });
    }
    public static void main(String[] args) {
        StreamIterate.fibonacci()
                .skip(10) // 跳过前10个元素
                .limit(10)
                .forEach(System.out::println);
        StreamIterate.balaSong()
                .limit(7)
                .forEach(System.out::println);
    }
}
