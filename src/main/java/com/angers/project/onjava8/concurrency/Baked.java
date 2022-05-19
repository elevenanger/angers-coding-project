package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/18 14:38
 * @description : 并发-将面团分成四团并烘焙
 * 烘焙完成的蛋糕作为 CompletableFuture 流返回
 */
public class Baked {
    static class Pan {
        /**
         * 将面团放在盘子中
         * @param batter 面团
         * @return 放有面团的盘子
         */
        static Pan pan(Batter batter) {
            System.out.println("put batter in the pan");
            new Nap(0.1);
            return new Pan();
        }
    }

    /**
     * 对放有面团的盘子进行加热
     * @param pan 放有面团的盘子
     * @return 加热后的产物
     */
    static Baked heat(Pan pan){
        System.out.println("heat the pan");
        new Nap(0.1);
        return new Baked();
    }

    /**
     * 将面团分盘进行加热烘焙
     * @param cfBatter 面团
     * @return 烘焙后的面团
     */
    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfBatter){
        return cfBatter
                .thenApplyAsync(Baked.Pan::pan)
                .thenApplyAsync(Baked::heat);
    }

    /**
     * 四份面团烘焙完成的产物流
     */
    public static Stream<CompletableFuture<Baked>> batch(){
        CompletableFuture<Batter> batter = Batter.mix();
        return Stream.of(bake(batter),bake(batter),bake(batter),bake(batter));
    }
}