package com.angers.project.onjava8.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : liuanglin
 * @date : 2022/4/18 15:23
 * @description : 集合
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        integers.forEach(v -> System.out.print(v + " "));
    }
}
