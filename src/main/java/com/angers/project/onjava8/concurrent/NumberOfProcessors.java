package com.angers.project.onjava8.concurrent;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:31
 * @description : 查看当前机器的处理器个数
 */
public class NumberOfProcessors {
    public static void main(String[] args) {
        /*
        Java 最佳线程数一般为可用的处理器的个数
        因为这可以减少不同线程之间上下文切换的开销
        上下文切换指的是存储被挂起线程当前的状态
        以及找回继续执行线程被挂起时的状态继续执行线程任务
         */
        System.out.println(
                Runtime.getRuntime().availableProcessors());
    }
}
