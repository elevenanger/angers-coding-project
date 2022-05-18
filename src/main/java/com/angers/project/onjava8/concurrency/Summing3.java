package com.angers.project.onjava8.concurrency;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/17 09:37
 * @description :并发-使用自动拆箱装箱机制进行求和
 */
public class Summing3 {
    static long basicSum(Long[] numbers){
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return sum;
    }
    public static final int SZ = 10_000_000;
    public static final long CHECK = (long) SZ *((long) SZ +1)/2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        Long[] aL = new Long[SZ +1];
        Arrays.parallelSetAll(aL,i -> (long)i);
        Summing.timeTest("Long Array Stream Reduce",CHECK,
                () -> Arrays.stream(aL).reduce(0L,Long::sum));
        Summing.timeTest("Long Basic Sum",CHECK,
                () -> basicSum(aL));
        Summing.timeTest("Long Parallel Prefix",CHECK,
                () -> {
            Arrays.parallelPrefix(aL,Long::sum);
            return aL[aL.length - 1];});
    }
}
