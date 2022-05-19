package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/5/18 14:21
 * @description : 并发-使用 CompletableFuture 串联一些列的操作
 * 模拟蛋糕制作的过程
 * 首先将各种配料混合成面团
 */
public class Batter {
    Batter() {
        System.out.println("make a batter");
    }

    static class Eggs{
        public Eggs() {
            System.out.println("make eggs");
        }
    }
    static class Milk{
        public Milk() {
            System.out.println("make milk");
        }
    }
    static class Sugar{
        public Sugar() {
            System.out.println("make sugar");
        }
    }
    static class Flour{
        public Flour() {
            System.out.println("make flour");
        }
    }

    /**
     * 制作食材
     * @param ingredient 食材
     * @return 制作完成的食材
     * @param <T> 食材类型
     */
    static <T>T prepare (T ingredient){
        new Nap(0.1);
        return ingredient;
    }

    /**
     * 储存制作完成的食材
     * @param ingredient 食材
     * @return 使用 CompletableFuture 接收已经完成制作的食材
     * @param <T> 食材类型
     */
    static <T>CompletableFuture<T> prep(T ingredient){
        return CompletableFuture
                .completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    /**
     * 将食材混合成面团
     * @return 食材混合而成的面团
     */
    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> egg = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        // 所有的食材制作完成之后，将其混合在一起
        CompletableFuture.allOf(egg,milk,sugar,flour).join();
        // 等待一段时间
        new Nap(0.1);
        // 将原材料混合成一个面团
        return CompletableFuture.completedFuture(new Batter());
    }
}
