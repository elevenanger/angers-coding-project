package com.angers.project.onjava8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : liuanglin
 * @date : 2022/5/18 08:46
 * @description : 并发-CompletableFuture 的一些常见用法
 */
public class CompletableUtilities {
    public static void showR(CompletableFuture<?> c){
        try {
            System.out.println(c.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void voidR(CompletableFuture<Void> c){
        try {
            c.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}