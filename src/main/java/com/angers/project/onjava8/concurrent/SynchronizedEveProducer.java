package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/6/5 20:46
 * @description :
 */
public class SynchronizedEveProducer extends IntGenerator{
    private int currentValue;

    @Override
    public synchronized int next() {
        ++ currentValue;
        new Nap(0.01);
        ++ currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEveProducer());
    }
}
