package com.angers.project.corejava.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SortAndShuffle {

    public static void main (String [] args){

        LinkedList<String> strings1 = new LinkedList<>();
        strings1.add("a.strings1");
        strings1.add("c.strings1");
        strings1.add("b.strings1");
        /*
        使用 Collections.sort() 对链表中的数据进行排序
        链表中的元素类型需要是实现了 Comparable 的类
         */
        Collections.sort(strings1);
        log.info(strings1.toString());
        /*
        传入 Comparator 对象进行排序
        对 collection 进行排序比较低效
        排序原理：
        将链表转换成数组
        对数组进行排序
        然后将排序后的数组拷贝回链表

        排序的集合需要是不可修改的，但是不必是可调整大小的
        1、实现 set 方法的集合是可修改的
        2、实现 add 和 remove 方法的集合是可调整大小的
         */
        strings1.sort(Comparator.reverseOrder());
        log.info(strings1.toString());

        /*
        与数组顺序排列相对，Collections 类还有一个 shuffle 方法
        对集合元素进行随机排列
        如果对一个没有实现 RandomAccess 的集合使用 shuffle 方法
        shuffle 方法会将其转换成数组，将数组元素随机排列，然后将数组拷贝回原来的集合
         */
        Collections.shuffle(strings1);
        log.info(strings1.toString());

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winNumber = numbers.subList(0,6);
        winNumber.sort(Comparator.naturalOrder());
        log.info(winNumber.toString());

        /*
        使用 Collections.binarySearch 对集合进行搜索，返回搜索值在集合中的位置
        二分搜索需要随机访问
        如果对于一个链表使用 binarySearch 方法，将会变成线性搜索
         */
        int i = Collections.binarySearch(strings1,"a");
        log.info(String.valueOf(i));
        int j = Collections.binarySearch(strings1,"c.strings1");
        log.info(strings1.toString()+Integer.toString(j));
        numbers.sort(Comparator.naturalOrder());
        log.info(numbers.toString());
        int c = Collections.binarySearch(numbers,11);
        log.info(Integer.toString(c));

        /*
        使用 lambda 表达式结合方法对集合进行操作
         */
        numbers.removeIf( w -> w < 20);
        log.info(numbers.toString());
        strings1.replaceAll(String::toUpperCase);
        log.info(strings1.toString());
    }
}
