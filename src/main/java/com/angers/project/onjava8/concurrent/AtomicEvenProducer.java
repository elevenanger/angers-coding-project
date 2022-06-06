package com.angers.project.onjava8.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/6/6 09:32
 * @description : 使用原子类重写 EvenProducer
 */
public class AtomicEvenProducer extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenProducer());
        /* output :
        未发现奇数
         */
    }
}
