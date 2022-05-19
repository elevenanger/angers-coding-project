package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/5/18 09:27
 * @description : 并发-组合使用两个 CompletableFuture
 */
public class Workable {
    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                '}';
    }

    public static Workable work(Workable tt){
        new Nap(tt.duration);
        // 表示工作已经完成
        tt.id = tt.id + " completed";
        System.out.println(tt);
        return tt;
    }

    public static CompletableFuture<Workable> make (String id,double duration){
        return CompletableFuture
                .completedFuture(new Workable(id ,duration))
                .thenApplyAsync(Workable::work);
    }
}
