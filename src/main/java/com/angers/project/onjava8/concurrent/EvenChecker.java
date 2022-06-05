package com.angers.project.onjava8.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/6/5 20:16
 * @description :
 */
public class EvenChecker implements Runnable{
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if (val % 2 != 0){
                System.out.println(val + " 不是偶数！");
                intGenerator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp , int count){
        List<CompletableFuture<Void>> checkers =
                IntStream.range(0,count)
                        .mapToObj(i -> new EvenChecker(gp,i))
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        checkers.forEach(CompletableFuture::join);
    }
    public static void test(IntGenerator gp){
        new TimedAbort(2,"未发现偶数");
        test(gp,10);
    }
}