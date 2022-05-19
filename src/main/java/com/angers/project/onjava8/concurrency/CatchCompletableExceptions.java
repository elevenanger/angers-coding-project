package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.common.CommonUtils;


/**
 * @author : liuanglin
 * @date : 2022/5/18 16:29
 * @description : 使用 CompletableFuture 自带的机制来自动响应异常
 * 在调用链中插入 CompletableFuture 有三个选项 exceptionally() handle() whenComplete()
 */
public class CatchCompletableExceptions {
    static void handleException(int failCount){
        CompletableExceptions.test("exceptionally",failCount)
                .exceptionally( throwable -> {
                    if (throwable == null) System.out.println("Don't get exception yet");
                    return new Breakable(throwable.getMessage(),0);
                }).thenAccept( str -> System.out.println("result " + str));

        CompletableExceptions
                .test("handle",failCount)
                .handle((result,fail) -> {
                    if (fail != null) return "Failure recovery object";
                    else return result + " is good";
                }).thenAccept(s -> System.out.println("result " + s));

        CompletableExceptions.test("whenComplete",failCount)
                .whenComplete(((breakable, throwable) -> {
                    if (throwable != null) System.out.println("It failed");
                    else System.out.println(breakable + " OK");
                })).thenAccept(breakable -> System.out.println("result: " + breakable));
    }

    public static void main(String[] args) {
        CommonUtils.printDivide("Failure Mode");
        handleException(2);
        CommonUtils.printDivide("Success mode");
        handleException(0);
    }
}
