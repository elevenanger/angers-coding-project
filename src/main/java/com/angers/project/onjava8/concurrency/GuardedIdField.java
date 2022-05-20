package com.angers.project.onjava8.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/5/19 08:37
 * @description : 并发-使用 AtomicInteger 作为 id 计数器
 */
public class GuardedIdField implements HasId{
    private static AtomicInteger counter = new AtomicInteger();
    private int id = counter.getAndIncrement();

    @Override
    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        IdChecker.test(GuardedIdField::new);

        /*
        output : 0
        说明 AtomicInteger 是线程安全的
         */
    }
}
