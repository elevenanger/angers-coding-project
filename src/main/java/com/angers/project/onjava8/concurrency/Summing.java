package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.validating.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 08:53
 * @description :并发-对于一个序列的数进行求和
 */
public class Summing {
    static void timeTest(String id, long checkValue, LongSupplier operation){
        System.out.println(id + ": ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue) System.out.println(timer.duration() + "ms");
        else System.out.format("result : %d%n checkValue: %d%n",result,checkValue);
    }
    public static final int SZ = 100_000_000;
    public static final long CHECK = (long) SZ * ((long) SZ +1)/2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        timeTest("Sum Stream" ,CHECK,() -> LongStream.rangeClosed(0,SZ).sum());
        timeTest("Sum Stream Parallel",CHECK,()->LongStream.rangeClosed(0,SZ).parallel().sum());
        timeTest("Sum Iterated",CHECK,() ->
                LongStream.iterate(0,i -> i+1).limit(SZ+1).sum());
    }
}
