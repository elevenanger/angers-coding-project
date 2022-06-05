package com.angers.project.onjava8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:44
 * @description :
 */
class ShowThread implements Runnable {
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName());
    }
}
public class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(
                Runtime.getRuntime().availableProcessors());
        /*
        创建 newWorkStealingPool() 将会使用所有的可用处理器
         */
        ExecutorService exec = Executors.newWorkStealingPool();
        IntStream.range(0,10)
                .mapToObj(n -> new ShowThread())
                .forEach(exec::execute);
        exec.awaitTermination(1, TimeUnit.SECONDS);
    }
}
