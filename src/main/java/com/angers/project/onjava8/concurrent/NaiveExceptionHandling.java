package com.angers.project.onjava8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:57
 * @description :
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        // 使用 execute() 方法正确捕捉到异常
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
        }catch (RuntimeException e){
            System.out.println("Exception was handled.");
        }finally {
            exec.shutdown();
        }
    }
}
