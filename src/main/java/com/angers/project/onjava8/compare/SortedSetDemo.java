package com.angers.project.onjava8.compare;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/6/3 17:22
 * @description : 排序集合的特性
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = Arrays.stream(
                ("A B C D E F G H I J K").split(" "))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortedSet);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        System.out.println(sortedSet.headSet("C"));
        System.out.println(sortedSet.tailSet("E"));
        System.out.println(sortedSet.subSet("B","F"));
    }
}
