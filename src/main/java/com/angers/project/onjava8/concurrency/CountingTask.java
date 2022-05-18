package com.angers.project.onjava8.concurrency;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 14:28
 * @description : 并发-使用 Callable 替代 Runnable
 */
public class CountingTask implements Callable<Integer> {
    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    /**
     * 单个 CountingTask 产生的结果完全独立于其它的任务
     * 它们之间没有可变共享状态
     * @return call() 计算返回的值
     */
    @Override
    public Integer call() throws Exception {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
        return val;
    }

    public static Integer extractResult(Future<Integer> f){
        try {
            // 等待任务执行结束，获取任务执行的结果
            return f.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        /*
        创建多个 Callable 任务
         */
        List<CountingTask> tasks =
                IntStream.range(0,100)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());
        /*
        future ：提交一个任务，不需要等待它完成的机制
        使用 ExecutorService.invokeAll() 启动所有的 Callable 任务
        每个任务都会返回一个 Future 对象
         */
        List<Future<Integer>> futures = exec.invokeAll(tasks);
        Integer sum =
                futures.stream()
                // 获取 Future 对象中的任务执行结果
                .map(CountingTask::extractResult)
                .reduce(0,Integer::sum);
        System.out.println("sum=" + sum);
        exec.shutdown();

        ExecutorService singleExec = Executors.newSingleThreadExecutor();
        // 使用 submit 方法提交单个 Callable 任务
        Future<Integer> f = singleExec.submit(new CountingTask(99));
        // 在任务尚未执行完成之前调用 Future.call() 方法 调用将会阻塞直到返回结果
        System.out.println(f.get());
        singleExec.shutdown();

        /*
        因为每个操作都是无共享的
        所以可以简化为直接使用 parallel stream
         */
        System.out.println(
                IntStream.range(0,10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> {
                            try {
                                return ct.call();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .reduce(0,Integer::sum)
        );
    }
}
