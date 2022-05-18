package com.angers.project.onjava8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 11:00
 * @description : 并发-使用多线程处理任务
 */
public class CachedThreadPoolExecutor {
    public static void main(String[] args) {
        // Executors.newCachedThreadPool() 创建线程池，成分利用多处理器处理任务
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        exec.shutdown();
    }
}
