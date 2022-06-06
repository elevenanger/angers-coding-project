package com.angers.project.onjava8.concurrent;

import java.util.function.IntSupplier;

/**
 * @author : liuanglin
 * @date : 2022/6/6 08:46
 * @description :
 */
public abstract class IntTestable implements Runnable, IntSupplier {
    abstract void evenIncrement();

    @Override
    public void run() {
        while (true) evenIncrement();
    }
}
