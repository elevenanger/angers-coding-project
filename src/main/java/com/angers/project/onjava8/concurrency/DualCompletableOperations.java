package com.angers.project.onjava8.concurrency;

import java.util.concurrent.CompletableFuture;
import static com.angers.project.onjava8.concurrency.CompletableUtilities.*;

/**
 * @author : liuanglin
 * @date : 2022/5/18 09:34
 * @description :
 */
public class DualCompletableOperations {
    static CompletableFuture<Workable> cfA;
    static CompletableFuture<Workable> cfB;
    static void init(){
        cfA = Workable.make("A",0.15);
        cfB = Workable.make("B",0.10);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("***************");
    }

    public static void main(String[] args) {
        init();
        voidR(cfA.runAfterEitherAsync(cfB,() ->
                System.out.println("runAfterEither")));
        join();

        init();
        voidR(cfA.runAfterBothAsync(cfB,() ->
                System.out.println("runAfterBoth")));
        join();

        init();
        showR(cfA.applyToEitherAsync(cfB, workable -> {
            System.out.println("applyToEitherAsync : " + workable);
            return workable;
        }));
        join();

        init();
        voidR(cfA.acceptEitherAsync(cfB,workable -> {
            System.out.println("acceptEither : " + workable);
        }));
        join();

        init();
        voidR(cfA.thenAcceptBothAsync(cfB,((workable, workable2) -> {
            System.out.println("thenAcceptBoth : " + workable + "\t" + workable2);
        })));
        join();

        init();
        showR(cfA.thenCombineAsync(cfB,(w1,w2) -> {
            System.out.println("thenCombine : " + w1 + "\t" + w2);
            return w1;
        }));
        join();

        init();
        CompletableFuture<Workable> cfC = Workable.make("C",0.08);
        CompletableFuture<Workable> cfD = Workable.make("D",0.09);
        CompletableFuture.anyOf(cfA,cfB,cfC,cfD).thenRunAsync(() ->
                System.out.println("anyOf"));
        join();

        init();
        cfC = Workable.make("C",0.08);
        cfD = Workable.make("D",0.09);
        CompletableFuture.anyOf(cfA,cfB,cfC,cfD).thenRunAsync(() ->
                System.out.println("allOf"));
        join();
    }
}
