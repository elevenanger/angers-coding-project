package com.angers.project.onjava8.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/6/6 09:29
 * @description : 使用 AtomicInteger 类
 */
public class AtomicIntegerTest extends IntTestable{
    private AtomicInteger i = new AtomicInteger(0);

    /**
     * 使用 AtomicInteger 可以省略 Synchronized 关键字
     */
    @Override
    void evenIncrement() {
        i.getAndAdd(2);
    }

    @Override
    public int getAsInt() {
        return i.get();
    }

    public static void main(String[] args) {
        Atomicity.test(new AtomicIntegerTest());
        /* output :
        未发现异常
         */
    }
}
