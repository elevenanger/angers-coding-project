package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liuanglin
 * @date : 2022/6/6 11:11
 * @description : 使用 Lock 对象防止线程冲突
 */
public class MutexEvenProducer extends IntGenerator{
    private int currentEvenValue = 0;
    // 显式地声明锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        // 加锁
        lock.lock();
        try {
            ++ currentEvenValue;
            new Nap(0.01);
            ++ currentEvenValue;
            /*
            return 必须在锁释放之前
             */
            return currentEvenValue;
        }finally {
            /*
            必须使用 try-finally 语句调用 lock()
            在 finally 中调用 unlock() 释放锁
            这是唯一可以确保锁被正确释放的方式
            显示声明 Lock 对象
            使用 try-finally
            在程序出现异常时
            可以执行代码确保程序的状态
            优雅关闭锁
             */
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenProducer());
        /*
        output
        未发现奇数
         */
    }
}
