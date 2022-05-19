package com.angers.project.onjava8.concurrency;

import java.util.concurrent.CompletableFuture;

import static com.angers.project.onjava8.concurrency.CompletableUtilities.*;

/**
 * @author : liuanglin
 * @date : 2022/5/18 08:50
 * @description :
 */
public class CompletableOperations {
    static CompletableFuture<Integer> cfi(int i){
        return CompletableFuture.completedFuture(Integer.valueOf(i));
    }

    public static void main(String[] args) {
        showR(cfi(1));
        voidR(cfi(2).thenRunAsync(() -> System.out.println("thenRunAsync")));
        voidR(CompletableFuture.runAsync(() -> System.out.println("runAsync is static")));
        showR(CompletableFuture.supplyAsync(() -> 99));
        voidR(cfi(3).thenAcceptAsync( i -> System.out.println("thenAcceptAsync:" + i)));
        showR(cfi(5).thenApplyAsync( i -> i + 93));
        showR(cfi(6).thenComposeAsync(integer -> cfi(integer + 99)));
        CompletableFuture<Integer> c = cfi(7);
        c.obtrudeValue(99);
        showR(c);
        showR(cfi(8).toCompletableFuture());
        c = new CompletableFuture<>();
        c.complete(9);
        showR(c);
        c = new CompletableFuture<>();
        c.cancel(true);
        System.out.println("cancelled : " + c.isCancelled());
        System.out.println("complete exceptionally : " + c.isCompletedExceptionally());
        System.out.println("done : " + c.isDone());
        System.out.println(c);
        c = new CompletableFuture<>();
        System.out.println(c.getNow(999));
        c = new CompletableFuture<>();
        c.thenApplyAsync( i -> i + 93).thenApplyAsync( i -> i * 94);
        System.out.println("dependents : " + c.getNumberOfDependents());
        c.thenApplyAsync( i -> i/2);
        System.out.println("dependents : " + c.getNumberOfDependents());
    }
}
