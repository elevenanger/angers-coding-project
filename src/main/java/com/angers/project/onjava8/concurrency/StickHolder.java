package com.angers.project.onjava8.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : liuanglin
 * @date : 2022/5/18 19:01
 * @description : 并发-死锁-哲学家筷子问题
 */
public class StickHolder {
    private static class Chopstick{}
    private Chopstick chopstick = new Chopstick();

    /*
    BlockingQueue 是为并发设计的集合
    调用 take() 如果 queue 中没有元素
    它会阻塞
    直到一个新的元素被加入集合 put()
    block 将会被释放并返回刚刚新增的元素

    设置集合容量为 1
     */
    private BlockingQueue<Chopstick> holder = new ArrayBlockingQueue<>(1);

    public StickHolder() {
        putDown();
    }

    public void pickUp() {
        try {
            holder.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void putDown(){
        try {
            holder.put(chopstick);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
