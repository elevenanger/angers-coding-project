package com.angers.project.onjava8.concurrency;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/17 09:17
 * @description :并发-将数值存放在数组中进行求和
 */
public class Summing2 {
    static long basicSum(long [] numbers){
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static final int SZ = 200_000_000;
    public static final long CHECK = (long) SZ * ((long) SZ +1 ) / 2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        long [] la = new long[SZ+1];
        Arrays.parallelSetAll(la,i -> i);
        Summing.timeTest("Array Stream Sum ",CHECK,() -> Arrays.stream(la).sum());
        Summing.timeTest("Parallel Sum",CHECK,() ->
                Arrays.stream(la).parallel().sum());
        Summing.timeTest("Basic Sum" , CHECK,() ->
                basicSum(la));
        Summing.timeTest("Parallel Prefix",CHECK,() ->
        {
            Arrays.parallelPrefix(la,Long::sum);
            return la[la.length-1];
        });
    }
}