package com.angers.project.onjava8.concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 10:20
 * @description : 并发-使用 IntStream 产生元素序列
 */
public class ParallelStreamPuzzle3 {
    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0,30)
                .peek(value -> System.out.println(value + " : " + Thread.currentThread().getName()))
                .limit(10)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integers);
    }
}
