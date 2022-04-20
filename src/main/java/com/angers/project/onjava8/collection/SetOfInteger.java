package com.angers.project.onjava8.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author : liuanglin
 * @date : 2022/4/19 11:07
 * @description : 集合-set
 * set 中每个元素都不重复
 * 不保存一个对象的多个实例
 * set 最常见的用法是用于查找一个元素是否存在
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random random = new Random(93);
        Set <Integer> integers = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            integers.add(random.nextInt(30));
        }
        System.out.println(integers);
    }
}
