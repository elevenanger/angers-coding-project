package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/5/17 10:43
 * @description : 并发-处理任务
 */
public class NapTask implements Runnable{

    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask{" +
                "id=" + id +
                '}';
    }
}
