package com.angers.project.onjava8.generics;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:24
 */
public class Fibonacci implements Supplier<Integer> {
    private int count = 0;
    @Override
    public Integer get() {
        return fib(count ++);
    }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(15)
                .map(integer -> integer + " ")
                .forEach(System.out::print);
    }
}
