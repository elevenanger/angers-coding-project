package com.angers.project.onjava8.concurrency;

/**
 * @author : liuanglin
 * @date : 2022/5/18 19:08
 * @description : 并发-死锁-哲学家筷子问题
 */
public class Philosopher implements Runnable{
    private final int seat;
    private final StickHolder left;
    private final StickHolder right;

    public Philosopher(int seat, StickHolder left, StickHolder right) {
        this.seat = seat;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "seat=" + seat +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            right.pickUp();
            left.pickUp();
            System.out.println(this + " eating");
            right.putDown();
            left.putDown();
        }
    }
}
