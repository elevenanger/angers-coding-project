package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.List;
import java.util.Queue;
import java.util.SplittableRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/6/6 14:06
 * @description : 优先级阻塞队列
 */
class Prioritized implements Comparable<Prioritized> {
    private static AtomicInteger counter = new AtomicInteger();
    private final int id = counter.getAndIncrement();
    private final int priority;
    private static List<Prioritized> sequence = new CopyOnWriteArrayList<>();
    public Prioritized(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Prioritized o) {
        return Integer.compare(o.priority,priority);
    }
    public void displaySequence() {
        AtomicInteger count = new AtomicInteger();
        sequence.forEach(prioritized -> {
                    System.out.printf("(%d : %d)",prioritized.id,prioritized.priority);
                    if (count.incrementAndGet() % 5 == 0) System.out.println();});
    }
    public static class EndSequential extends Prioritized {
        public EndSequential() {
            super(-1);
        }
    }
}

class Producer implements Runnable {
    private static AtomicInteger seed = new AtomicInteger(93);
    private SplittableRandom random =
            new SplittableRandom(seed.getAndAdd(10));
    private Queue<Prioritized> queue;

    public Producer(Queue<Prioritized> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        random.ints(10,0,20)
                .mapToObj(Prioritized::new)
                .peek(prioritized -> new Nap(random.nextDouble() / 10))
                .forEach(prioritized -> queue.add(prioritized));
        queue.add(new Prioritized.EndSequential());
    }
}

class Consumer implements Runnable {
    private PriorityBlockingQueue<Prioritized> queue;
    private SplittableRandom random = new SplittableRandom(93);

    public Consumer(PriorityBlockingQueue<Prioritized> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Prioritized prioritized = queue.take();
                System.out.println(prioritized);
                if (prioritized instanceof Prioritized.EndSequential){
                    prioritized.displaySequence();
                    break;
                }
                new Nap(random.nextDouble() / 10);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        PriorityBlockingQueue<Prioritized> queue = new PriorityBlockingQueue<>();
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Consumer(queue)).join();
    }
}
