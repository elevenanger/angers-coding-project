package com.angers.project.onjava8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/6/5 20:07
 * @description :
 */
public class SetDefaultHandler {
    public static void main(String[] args) {
        // 设置默认的线程异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}
