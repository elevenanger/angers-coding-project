package com.angers.project.onjava8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/5/17 17:23
 * @description : 并发-使用 lambda 表达式传递函数给 ExecutorService 执行
 */
public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        /*
        因为 lambda 表达式是根据方法签名一致性
        可以传递符合相应方法签名的函数给 ExecutorService 执行
         */
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(() -> System.out.println("Lambda1"));
        exec.submit(new NotRunnable()::go);
        exec.submit(()->{
            System.out.println("lambda2");
            return 1;
        });
        exec.submit(new NotCallable()::get);
        exec.shutdown();
    }
}

class NotRunnable {
    public void go(){
        System.out.println("NotRunnable.go()");
    }
}

class NotCallable {
    public Integer get(){
        System.out.println("NotCallable.get()");
        return 1;
    }
}