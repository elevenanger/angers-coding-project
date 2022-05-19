package com.angers.project.onjava8.concurrency;

import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/18 18:33
 * @description : 并发- Stream 对异常的处理方式
 */
public class StreamExceptions {
    static Stream<Breakable> test(String id , int failCount){
        return Stream.of(
                new Breakable(id,failCount))
                .map(Breakable::work)
                .map(Breakable::work)
                .map(Breakable::work)
                .map(Breakable::work);
    }

    public static void main(String[] args) {
        /*
        在 Stream 中
        除非有终止操作
        不然 Stream 的过程操作都不会发生
         */
        test("A",1);
        test("B",2);
        Stream<Breakable> c = test("C",3);
        test("D",4);
        test("E",5);
        System.out.println("Entering try");
        try {
            /*
            对 Stream 使用 forEach 终止操作，捕获异常
            Stream 相比 CompletableFuture 不会储存异常
            而是直接抛出异常
             */
            c.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
