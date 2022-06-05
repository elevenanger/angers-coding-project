package com.angers.project.onjava8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:49
 * @description :
 */
public class SwallowedException {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(
                () -> {
                    throw new RuntimeException();});
        exec.shutdown();
        /*
        程序不会输出任何信息
        这说明在线程中抛出异常会比较麻烦
        需要特别注意
        一旦异常超出任务的 run() 方法
        它将被传播到控制台
        除非你采用特殊的手段来捕捉这种异常
         */
    }
}
