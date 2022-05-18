package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.validating.Timer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 08:21
 * @description :并发-使用 parallel stream
 */
public class ParallelPrime {
    public static boolean isPrime(long n){
        return LongStream.rangeClosed(2,(long) Math.sqrt(n))
                .noneMatch( i -> n % i == 0);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        /*
        java stream 使用的是内部迭代
        它控制自己的迭代器
        stream 使用的迭代器为 Spliterator
        它可以很容易的自动进行分片
        所以 stream 可以使用 parallel 利用计算机的多个处理器同时处理 stream
         */
        List<String> primes = LongStream.iterate(2,i -> i +1)
                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(100_000)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println(timer.duration());
        System.out.println(primes.subList(0,100));
    }
}
