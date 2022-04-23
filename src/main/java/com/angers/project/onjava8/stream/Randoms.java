package com.angers.project.onjava8.stream;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author : liuanglin
 * @date : 2022/4/22 11:37
 * @description : 流-使用流处理一系列的随机数
 */
public class Randoms {
    static Random random = new Random(93);
    static void declareRandoms(){
        random.ints(10,20) // 产生 IntStream
                .distinct()
                .limit(10)
                .sorted()
                .forEach(v -> System.out.print(v + " "));
    }

    static void imperativeRandoms(){
        SortedSet<Integer> integers = new TreeSet<>();
        while (integers.size() < 10) {
            int i = random.nextInt(30);
            if (i>=10 && i < 20) integers.add(i);
        }
        System.out.println(integers);
    }

    public static void main(String[] args) {
        declareRandoms();
        System.out.println();
        imperativeRandoms();
    }
}
