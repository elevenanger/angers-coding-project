package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 10:49
 * @description : 并发-使用单线程处理器处理任务
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        // 创建一个单线程处理器
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0,10)
                // 创建 NapTask 任务 （RUNNABLE）对象
                .mapToObj(NapTask::new)
                // 将任务提交给处理器使用处理器处理任务
                .forEach(exec::execute);
        System.out.println("All Task Submitted.");
        // 处理完成后终止处理器
        exec.shutdown();
        // 处理器终止之前每隔 0.1 秒打印一次信息
        while (!exec.isTerminated()) {
            System.out.println(
                    Thread.currentThread().getName() +
                            " Awaiting termination."
            );
            new Nap(0.1);
        }
    }
}
