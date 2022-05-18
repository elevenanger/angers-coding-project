package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 18:00
 * @description : 并发-终止任务
 */
public class QuitTask implements Runnable{
    private final int id;

    public QuitTask(int id) {
        this.id = id;
    }

    /*
    如果终止标识可以被其它的任务改变
    会存在冲突以及异常结束任务的情况
    使用 Atomic 类中的数据类型可以应对并发问题
    使用 AtomicBoolean 作为任务的运行标识
     */
    private AtomicBoolean runningFlag = new AtomicBoolean(true);

    /*
    任务 quit 方法
    将 runningFlag 运行标识置位 false
     */
    public void quit() {runningFlag.set(false);}

    /*
    终止任务最好的方式是设置一个标识
    任务定期检查该标识
    如果检查到终止的条件
    任务可以控制并执行自己的终止逻辑，优雅地结束任务
     */
    @Override
    public void run() {
        /*
        只要 runningFlag 为 true
        任务将会一直运行下去
         */
        while(runningFlag.get()) new Nap(0.1);
        /*
        任务结束时需要执行的业务逻辑
         */
        System.out.print(id + " ");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<QuitTask> tasks =
                IntStream.range(1,100)
                        .mapToObj(QuitTask::new)
                        .peek(exec::execute)
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuitTask::quit);
        exec.shutdown();
    }
}