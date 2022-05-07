package com.angers.project.onjava8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/6 08:37
 * @description : 泛型-泛型随机数组列表
 */
public class RandomList <T> extends ArrayList<T> {
    private Random random = new Random(93);
    public T select(){
        return get(random.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        randomList.addAll(Arrays.asList("we are the world".split(" ")));
        IntStream.range(0,5)
                .forEach( i -> System.out.print(randomList.select() + " "));
    }
}