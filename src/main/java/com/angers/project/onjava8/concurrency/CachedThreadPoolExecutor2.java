package com.angers.project.onjava8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 11:08
 * @description : 并发-多线程之间相互干涉的情况
 */
public class CachedThreadPoolExecutor2 {
    public static void main(String[] args) {
        /*
        88 pool-1-thread-5 5882
        因为所有的任务都尝试写单一的 val 实例
        互相之间产生了干涉
        导致输出的结果非预期结果
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,100)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
