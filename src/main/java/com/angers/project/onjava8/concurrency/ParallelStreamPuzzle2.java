package com.angers.project.onjava8.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/17 10:11
 * @description :
 */
public class ParallelStreamPuzzle2 {
    public static final Deque<String> trace = new ConcurrentLinkedDeque<>();
    static class IntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger();
        @Override
        public Integer get() {
            trace.add(current.get() + " : " + Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> integers =
                Stream.generate(new IntGenerator())
                        .limit(10)
                        .parallel()
                        .collect(Collectors.toList());
        System.out.println(integers);
        Files.write(Paths.get("PSP2.txt"),trace);
    }
}
