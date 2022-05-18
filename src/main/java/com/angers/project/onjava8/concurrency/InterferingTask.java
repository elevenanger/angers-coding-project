package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 11:05
 * @description : 并发-非线程安全的类的并发操作会产生非预期的结果
 */
public class InterferingTask implements Runnable{
    final int id ;

    private static Integer val = 0;

    public InterferingTask(int id) {
        this.id = id;
    }

    /*
    因为 Runnable 没有返回值
    只能通过 副作用 产生结果
    即操作改变它所处的环境而不是返回一个结果
    在这里则是操作 val 变量的值
    val 在此环境下可以称之为 可变共享状态
    多个线程并发运行会改变同一个变量会产生互相干涉的情况
    这种情况称之为竞争条件
    副作用是并发编程中最大的问题

    避免竞争条件最好的方式就是避免可变分享状态
    什么都不分享 share nothing
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val ++ ;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
    }

    public static void main(String[] args) {
        /*
        单线程
        每次执行都获得一致的结果
        这种现象称为线程限制
        任务都运行在同一个线程上限制了多线程的影响
         */
        ExecutorService single = Executors.newSingleThreadExecutor();
        IntStream.range(0,50)
                .mapToObj(InterferingTask::new)
                .forEach(single::execute);
        single.shutdown();

        new Nap(2);

        /*
        多线程
        每次执行都获得不一致的结果
        因为多个线程同时在操作 val
        导致线程之间互相影响
        结果出现不一致性
        该对象非线程安全
         */
        ExecutorService pool = Executors.newCachedThreadPool();
        IntStream.range(0,50)
                .mapToObj(InterferingTask::new)
                .forEach(pool::execute);
        pool.shutdown();
    }
}

