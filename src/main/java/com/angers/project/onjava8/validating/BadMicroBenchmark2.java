package com.angers.project.onjava8.validating;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

/**
 * @author : liuanglin
 * @date : 2022/4/28 15:34
 * @description :校验-基准
 */
public class BadMicroBenchmark2 {
    static final int SIZE = 5_000_000;

    public static void main(String[] args) {
        /*
        并行方法测试结果比非并行方法的测试结果时长要长
        测试结果不符合常理
        所以这个基准的计量因素是不好的计量基准
        因为这个计量过程没有考虑到 JVM 的热身机制对性能的影响
        JVM 经过一段时间的运行热身之后的性能要比冷启动的性能好很多
        所以导致测试结果偏离预期
         */
        long [] la = new long[SIZE];
        Random r = new Random();
        System.out.println("parallelSetAll : " +
                Timer.duration(() ->
                        Arrays.parallelSetAll(la ,n -> r.nextLong())));
        System.out.println("setAll : " +
                Timer.duration(() ->
                        Arrays.setAll(la ,n -> r.nextLong())));
        SplittableRandom sr = new SplittableRandom();
        System.out.println("parallelSetAll : " +
                Timer.duration(() ->
                        Arrays.parallelSetAll(la ,n -> sr.nextLong())));
        System.out.println("setAll : " +
                Timer.duration(() ->
                        Arrays.setAll(la ,n -> sr.nextLong())));
    }
}