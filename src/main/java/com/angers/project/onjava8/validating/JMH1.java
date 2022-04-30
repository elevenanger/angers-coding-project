package com.angers.project.onjava8.validating;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author : liuanglin
 * @date : 2022/4/28 15:53
 * @description :校验-使用 JMH 进行基准测试
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@Fork(1)
public class JMH1 {
    private long[] la;
    @Param({
            "1",
            "10",
            "100",
            "1000",
            "10000"
    })
    int size;

    @Setup
    public void setup(){
        la = new long[size];
    }
    @Benchmark
    public void setAll(){
        Arrays.setAll(la , n -> n);
    }
    @Benchmark
    public void parallelSetAll(){
        Arrays.parallelSetAll(la , n -> n);
    }
}