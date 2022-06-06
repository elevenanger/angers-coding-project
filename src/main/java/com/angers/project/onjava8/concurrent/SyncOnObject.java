package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;
import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/6/6 10:57
 * @description : synchronized 声明对象
 */
class DualSync {
    ConcurrentLinkedDeque<String> trace =
            new ConcurrentLinkedDeque<>();
    public synchronized void f(boolean nap) {
        for (int i = 0; i < 5; i++) {
            trace.add(String.format("f()" + i));
            if (nap) new Nap(0.01);
        }
    }

    private Object syncObject = new Object();
    public void g(boolean nap) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                trace.add(String.format("g()" + i));
                if (nap) new Nap(0.01);
            }
        }
    }
}

public class SyncOnObject {
    static void test(boolean fNap,boolean gNap){
        DualSync ds = new DualSync();
        List<CompletableFuture<Void>> cfs =
                Arrays.stream(new Runnable[] {
                        () -> ds.f(fNap),
                        () -> ds.g(gNap)})
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        cfs.forEach(CompletableFuture::join);
        ds.trace.forEach(System.out::println);
    }

    public static void main(String[] args) {
        /*
        synchronized 声明 f() 整个方法
        会作用于 this 对象
        synchronized 声明 g() 方法中的 Object 对象
        二者作用于不同的对象
        所以 f() 方法的调用不会阻碍 g() 方法的调用
        反之亦然
         */
        test(true,false);
        CommonUtils.printDivide("");
        test(false,true);
    }
}
