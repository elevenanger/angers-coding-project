package com.angers.project.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class ThreadTest {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000.00;

    public static void main(String [] args){
        /*
        使用独立线程来处理任务的简单步骤：
        1、在实现了 Runnable 接口的类中的 run 方法中实现任务的代码逻辑
        Runnable 是一个函数式的接口，也可以使用 lambda 表达式来进行实例化
        不要直接使用 Runnable 对象或者 Thread 类的 run 方法，它只会使用相同的线程处理任务

        线程的状态
        New
        Runnable
        Blocked
        Waiting
        Timed waiting
        Terminated
         */
        Runnable r = () -> {};
        /*
        2、从实例化的 Runnable 对象构造一个 Thread 对象
        线程创建之后还没开始运行，这时候状态是 NEW
         */
        Thread t = new Thread(r,"Test Thread");
        log.info(t.getState().toString());
        t.start();
        /*
        使用 start 方法启动新线程线程，执行任务逻辑
        一旦调用了 start 方法，线程的状态转为 RUNNABLE
        RUNNABLE 状态的线程可能没有真正的在运行
        线程的调度取决于操作系统的调度策略

        线程的其它状态：
        BLOCKED 当线程试图取得一个对象内在固有的锁（非 java.util.concurrent 的 Lock）
        这个锁目前被其它线程所持有，这个线程状态就会编程 BLOCKED
        只有在其它线程释放了这个锁，并且线程调度允许当前线程持有该锁的时候，状态才会变化

        WAITING 当一个线程等待另一个线程来通知调度程序某个条件时，它会进入 WAITING 状态

        TIMED WAITING 一些方法具有超时参数
        调用这些方法会使线程进入 TIMED WAITING 状态
        这个状态会持续到超时结束或者收到合适的通知

        TERMINATED 有两个原因会导致线程终止：
        1、run 正常结束
        2、未捕捉的异常导致 run 方法异常中断
         */
        log.info(t.getState().toString());


        Bank bank = new Bank(4,100000.00);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT*Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((int)(DELAY*new Random().nextDouble()));
                    if (bank.getAccounts()[0]<99990) Thread.currentThread().interrupt();
                }
            }catch (InterruptedException e){
                log.info(e.getMessage());
                Thread.currentThread().interrupt(); // 捕捉 sleep 方法抛出的异常，中断线程
            }finally {
                log.info(Thread.currentThread().getState().toString());
                log.info(Arrays.toString(bank.getAccounts()));
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT*Math.random();
                    bank.transfer(1,2,amount);
                    Thread.sleep((int)(DELAY*Math.random()));
                }
            }catch (InterruptedException e){
                log.info(e.getMessage());
                Thread.currentThread().interrupt();
            }
            finally {
                log.info(Arrays.toString(bank.getAccounts()));
            }
        };

        new Thread(task1,"First thread").start();
        new Thread(task2,"Second thread").start();

    }

}
