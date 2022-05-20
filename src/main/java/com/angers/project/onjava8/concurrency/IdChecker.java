package com.angers.project.onjava8.concurrency;

import com.angers.project.onjava8.generics.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/19 08:16
 * @description : 并发-使用并发生成 StaticIDField 对象
 */
public class IdChecker {
    public static final int SIZE = 100_000;
    static class MakeObjects implements Supplier<List<Integer>> {
        private Supplier<HasId> gen;

        public MakeObjects(Supplier<HasId> gen) {
            this.gen = gen;
        }

        @Override
        public List<Integer> get() {
            return Stream.generate(gen)
                    .limit(SIZE)
                    // 获取对象的id
                    .map(HasId::getId)
                    .collect(Collectors.toList());
        }
    }

    public static void test(Supplier<HasId> gen) {
        /*
        分别使用两个 CompletableFuture 任务运行 MakeObjects Supplier 方法
        将结果分别放入 HashSet 中
        取两个集合的交集

        output 47459
        说明 static 域和构造函数也不是线程安全的
         */
        CompletableFuture<List<Integer>>
                groupA = CompletableFuture
                .supplyAsync(new MakeObjects(gen));
        CompletableFuture<List<Integer>>
                groupB = CompletableFuture
                .supplyAsync(new MakeObjects(gen));
        groupA.thenAcceptBoth(groupB,(gA,gB) ->
                System.out.println(
                Sets.intersection(
                        new HashSet<>(gA),
                        new HashSet<>(gB)).size())).join();

    }

    public static void main(String[] args) {
        test(StaticIdField::new);
    }
}
