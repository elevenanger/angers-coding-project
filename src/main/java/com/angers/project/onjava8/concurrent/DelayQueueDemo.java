package com.angers.project.onjava8.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/6/6 12:06
 * @description : 延迟队列
 */
class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() +
                TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MICROSECONDS);
        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        return Long.compare(trigger, that.trigger);
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(),
                TimeUnit.MICROSECONDS);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", delta=" + delta +
                '}';
    }

    public String summary() {
        return String.format("(%d : %d)", id, delta);
    }

    public static class EndTask extends DelayedTask {
        EndTask(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            sequence.forEach(delayedTask -> System.out.println(delayedTask.summary()));
        }
    }
}

public class DelayQueueDemo {
    public static void main(String[] args) throws Exception {
        DelayQueue<DelayedTask> tasks =
                Stream.concat(
                                new Random(93)
                                        .ints(20, 0, 4000)
                                        .mapToObj(DelayedTask::new),
                                Stream.of(new DelayedTask.EndTask(4000)))
                        .collect(Collectors.toCollection(DelayQueue::new));
        while (!tasks.isEmpty()) tasks.take().run();
        /*
        (0 : 4000)
        (1 : 2518)
        (2 : 3499)
        (3 : 2484)
        (4 : 2037)
        (5 : 3449)
        (6 : 3990)
        (7 : 431)
        (8 : 934)
        (9 : 3662)
        (10 : 1933)
        (11 : 3025)
        (12 : 96)
        (13 : 3257)
        (14 : 1428)
        (15 : 856)
        (16 : 3482)
        (17 : 1852)
        (18 : 1446)
        (19 : 1915)
        (20 : 3009)
        DelayedTask{id=12, delta=96}
        DelayedTask{id=7, delta=431}
        DelayedTask{id=15, delta=856}
        DelayedTask{id=8, delta=934}
        DelayedTask{id=14, delta=1428}
        DelayedTask{id=18, delta=1446}
        DelayedTask{id=17, delta=1852}
        DelayedTask{id=10, delta=1933}
        DelayedTask{id=19, delta=1915}
        DelayedTask{id=4, delta=2037}
        DelayedTask{id=1, delta=2518}
        DelayedTask{id=3, delta=2484}
        DelayedTask{id=11, delta=3025}
        DelayedTask{id=20, delta=3009}
        DelayedTask{id=13, delta=3257}
        DelayedTask{id=2, delta=3499}
        DelayedTask{id=5, delta=3449}
        DelayedTask{id=16, delta=3482}
        DelayedTask{id=9, delta=3662}
        DelayedTask{id=6, delta=3990}

        DelayQueue 是 PriorityQueue 的一个变种
        无论元素的插入顺序如何
        等待时间最小的元素最先被取出
         */
    }
}