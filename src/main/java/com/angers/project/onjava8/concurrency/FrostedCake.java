package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/5/18 14:50
 * @description : 并发-创建一批糖霜 为蛋糕裹上糖霜
 */
final class Frosting {
    public Frosting() {
        System.out.println("frosting...");
    }

    /**
     * 创建糖霜
     * @return 创建好的糖霜
     */
    static CompletableFuture<Frosting> make(){
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}
public class FrostedCake {
    public FrostedCake(Baked baked,Frosting frosting) {
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake{}";
    }

    public static void main(String[] args) {
        Baked.batch().forEach(baked ->
                baked.thenCombineAsync(Frosting.make(),FrostedCake::new)
                        .thenAcceptAsync(System.out::println)
                        .join());
    }
}