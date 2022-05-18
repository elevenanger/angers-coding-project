package com.angers.project.onjava8.concurrency;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 10:02
 * @description :并发-交叉使用 Stream 和 Collection 可能会产生意想不到的情况
 */
public class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {

        private int current = 0;

        @Override
        public Integer get() {
            return current ++ ;
        }
    }

    public static void main(String[] args) {
        /*
        使用 parallel 生成的列表元素顺序为乱序
        不使用 parallel 为顺序
        使用 parallel
        所有的线程都同时在使用同一个生成器
        会导致元素产生的顺序为乱序
        使用线程必须捕捉所有的追踪信息存放在并发的数据结构中进行追踪
         */
        List<Integer> integers =
                Stream.generate(new IntGenerator())
                .limit(10)
                .parallel()
                .collect(Collectors.toList());
        System.out.println(integers);
        List<Integer> integers1 =
                Stream.generate(new IntGenerator())
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(integers1);
    }
}
