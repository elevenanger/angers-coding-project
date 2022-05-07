package com.angers.project.onjava8.generics;

import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:30
 */
public class IterableFibonacci extends Fibonacci implements Iterable <Integer>{
    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n --;
                return IterableFibonacci.this.get();
            }
        };
    }

    public static void main(String[] args) {
        new IterableFibonacci(20)
                .iterator()
                .forEachRemaining(integer -> System.out.print(integer + " "));
    }
}
