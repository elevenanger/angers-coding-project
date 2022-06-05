package com.angers.project.onjava8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:54
 * @description :
 */
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
        /* output :
        Exception in thread "pool-1-thread-1" java.lang.RuntimeException
        at com.angers.project.onjava8.concurrent.ExceptionThread.run(ExceptionThread.java:14)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:750)
         */
    }
}
