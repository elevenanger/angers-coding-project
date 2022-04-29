package com.angers.project.onjava8.validating;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/28 15:10
 * @description : 校验-基准
 */
public class BadMicroBenchmark {
    static final int SIZE = 250_000_000;

    public static void main(String[] args) {
        try {
            long [] la = new long[SIZE];
            // 比较 setAll() 和 parallelSetAll() 的性能
            System.out.println("setAll:" +
                    Timer.duration(() ->
                            Arrays.setAll(la,n -> n)));
            System.out.println("parallel set all:" +
                    Timer.duration(() ->
                            Arrays.parallelSetAll(la,n -> n)));
        }catch (OutOfMemoryError e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}