package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/5/18 19:12
 * @description : 并发-死锁
 */
public class DinningPhilosopher {
    private StickHolder [] sticks;
    private Philosopher [] philosophers;

    public DinningPhilosopher(int n) {
        sticks = new StickHolder[n];
        Arrays.setAll(sticks, i -> new StickHolder());
        philosophers = new Philosopher[n];
        Arrays.setAll(philosophers, i -> new Philosopher(i,sticks[i],sticks[(i+1) % n]));
        Arrays.stream(philosophers).forEach(CompletableFuture::runAsync);
    }

    public static void main(String[] args) {
        new DinningPhilosopher(5);
        new Nap(3,"shutdown");
    }
}
