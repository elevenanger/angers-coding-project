package com.angers.project.onjava8.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/5/18 15:33
 * @description : 并发- CompletableFuture 对处理链中异常的处理
 */
public class CompletableExceptions {

    /**
     * 执行 Breakable 测试
     * @param id id
     * @param failCount 错误次数
     * @return 完成的 Breakable 对象
     */
    static CompletableFuture<Breakable> test(String id,int failCount){
        return
                CompletableFuture
                        .completedFuture(new Breakable(id, failCount))
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work);
    }

    public static void main(String[] args) {
        /*
        通过日志发现在调用链之中已经抛出了异常
        但是异常没有抛出
         */
        test("A",1);
        test("B",2);
        test("C",3);
        test("D",4);
        test("E",5);

        try {
            test("F",2).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(
                test("G",2).isCompletedExceptionally()
        );
        System.out.println(test("H",2).isDone());
        CompletableFuture<Integer> cfi = new CompletableFuture<>();
        System.out.println("done : " + cfi.isDone());
        cfi.completeExceptionally(new RuntimeException("forced"));
        try {
            cfi.get();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}