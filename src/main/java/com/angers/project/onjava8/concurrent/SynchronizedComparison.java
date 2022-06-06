package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/6/6 10:00
 * @description : 使用 synchronized 关键字保护一段代码而非整个方法
 */
abstract class Guarded {
    AtomicLong callCount = new AtomicLong();

    abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "callCount=" + callCount.get() +
                '}';
    }
}

class SynchronizedMethod extends Guarded {
    @Override
    synchronized void method() {
        new Nap(0.01);
        callCount.incrementAndGet();
    }
}

class CriticalSection extends Guarded {
    @Override
    void method() {
        new Nap(0.01);
        /*
        使用 synchronized 声明一段代码
        这段代码成为知 critical section
         */
        synchronized (this){
            callCount.incrementAndGet();
        }
    }
}

class Caller implements Runnable {
    private Guarded guarded;
    Caller(Guarded guarded){
        this.guarded = guarded;
    }
    private AtomicLong successfulCalls = new AtomicLong();
    private AtomicBoolean stop = new AtomicBoolean(false);

    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {stop.set(true);}},2500);
        while (!stop.get()) {
            guarded.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println(Thread.currentThread().getName() + successfulCalls.get());
    }
}
public class SynchronizedComparison {
    static void test(Guarded guarded) {
        List<CompletableFuture<Void>> callers =
                Stream.of(
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded),
                        new Caller(guarded))
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        callers.forEach(CompletableFuture::join);
        System.out.println(guarded);
    }

    public static void main(String[] args) {
        test(new CriticalSection());
        test(new SynchronizedMethod());
        /* output :
        CriticalSection{callCount=2063}
        SynchronizedMethod{callCount=420}

        synchronized 声明一段代码比声明整个方法的执行效率更高
        在相同时间能能够产生更多的结果
         */
    }
}
