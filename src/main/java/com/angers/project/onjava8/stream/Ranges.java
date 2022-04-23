package com.angers.project.onjava8.stream;


import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/4/22 17:20
 * @description : 流-使用 IntStream 产生 int 序列
 */
public class Ranges {
    static void repeat(int n,Runnable r){
        IntStream
                .range(0,n)
                .forEach( i -> r.run());
    }

    static void greeting(){
        System.out.println("hello.");
    }

    public static void main(String[] args) {
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);
        result = 0;
        for (int i: IntStream.range(10,20).toArray()) {
                result += i;
        }
        System.out.println(result);
        System.out.println(IntStream.range(10,20).sum());

        repeat(3,Ranges::greeting);
        repeat(2,() -> System.out.println("hi."));
    }
}
