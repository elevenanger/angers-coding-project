package com.angers.project.onjava8.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/6/6 08:48
 * @description :
 */
public class Atomicity {
    public static void test(IntTestable it){
        new TimedAbort(2,"未发现异常");
        CompletableFuture.runAsync(it);
        while (true){
            // getAsInt() 是一个原子性操作
            int val = it.getAsInt();
            if (val % 2 != 0){
                System.out.println("测试失败，值为 ： "  + val);
                System.exit(0);
            }
        }
    }
}
