package com.angers.project.onjava8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/18 18:39
 * @description : CompletableFuture 和 parallel Stream 都不支持处理已检查的异常
 * 必须在调用该操作的逻辑中进行处理
 */
public class ThrowsChecked {
    class Checked extends Exception{}
    static ThrowsChecked noChecked(ThrowsChecked tc){
        return tc;
    }

    static ThrowsChecked withChecked(ThrowsChecked tc) throws Checked {
        return tc;
    }

    static void testStream(){
        Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::noChecked)
                /*
                方法抛出已检查的异常
                不能直接传递方法的引用
                必须写出 lambda 表达式
                对异常进行处理
                ComparableFuture 也是一样
                 */
                .map( tc -> {
                    try {
                        return withChecked(tc);
                    }catch (Checked e){
                        throw new RuntimeException(e);
                    }
                });
    }

    static void testCompletableFuture() {
        CompletableFuture
                .completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::noChecked)
                .thenApply(tc -> {
                    try {
                        return withChecked(tc);
                    }catch (Checked e){
                        throw new RuntimeException(e);
                    }
                });
    }

    public static void main(String[] args) {
        testStream();
        testCompletableFuture();
    }
}
