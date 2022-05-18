package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 18:34
 * @description : 并发-使用 CompletableFuture
 */
public class QuitCompletable {
    public static void main(String[] args) {
        List<QuitTask> tasks =
                IntStream.range(1,100)
                        .mapToObj(QuitTask::new)
                        .collect(Collectors.toList());
        /*
        使用 CompletableFuture 处理任务
        调用 runAsSync 方法执行任务的 run 方法
        因为 run 方法不返回任何值
        这里使用 Void 作为占位符
        使用 CompletableFuture 不需要 ExecutorService
        也不需要调用 shutdown() 方法来终止 Executor
         */
        List<CompletableFuture<Void>> completableFutures =
                tasks.stream()
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        new Nap(1);
        // 调用任务终止方法
        tasks.forEach(QuitTask::quit);
        // 使用 join 方法等待任务终止
        completableFutures.forEach(CompletableFuture::join);
    }
}
