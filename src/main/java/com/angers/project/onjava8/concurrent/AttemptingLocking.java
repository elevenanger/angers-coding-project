package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : liuanglin
 * @date : 2022/6/6 11:23
 * @description : 使用 concurrent 库中的 Lock 对象
 * 可以在达成指定条件的情况下放弃获得锁的操作
 */
public class AttemptingLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock() " + captured);
        }finally {
            if (captured) lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            // 等待两秒获取锁
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(
                    "tryLock(2,TimeUnit.SECONDS) " + captured);
        }finally {
            if (captured) lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptingLocking al = new AttemptingLocking();
        al.untimed(); // true 锁是可用状态
        al.timed(); // true 锁是可用状态
        CompletableFuture.runAsync( () -> {
            // 创建一个任务来占锁
            al.lock.lock();
            System.out.println("acquired");});
        new Nap(0.1);
        al.untimed(); // false 锁已经被任务占据
        al.timed(); // false 锁已经被任务占据
        /* output :
        tryLock() true
        tryLock(2,TimeUnit.SECONDS) true
        acquired
        tryLock() false
        tryLock(2,TimeUnit.SECONDS) false
        ReentrantLock 可以尝试获取锁
        如果锁已经被别的任务占据
        可以决定放弃获得锁或者做一些别的尝试
         */
    }
}
