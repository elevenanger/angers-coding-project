package com.angers.project.onjava8.concurrent;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author : liuanglin
 * @date : 2022/6/6 09:08
 * @description :
 */
public class CircularSet {
    private int [] array;
    private int size;
    private int index;

    public CircularSet(int size) {
        this.size = size;
        array = new int[size];
        Arrays.fill(array,-1);
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++ index % size;
    }

    public synchronized boolean contains(int val){
        OptionalInt result =
                Arrays.stream(array)
                .filter(i -> i ==val)
                .findAny();
        return result.isPresent();
    }
}
