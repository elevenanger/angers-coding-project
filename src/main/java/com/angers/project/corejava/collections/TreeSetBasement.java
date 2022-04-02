package com.angers.project.corejava.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet 相较 HashSet ，TreeSet 是有序集合
 * 以任意的顺序新增元素
 * 迭代的会按照顺序遍历
 */
@Slf4j
public class TreeSetBasement {

    public static void main(String [] args){
        // 使用 TreeSet 存放的元素需要是可排序的
        TreeSet<String> sortedTreeSet = new TreeSet<>();
        /*
        当一个新元素被增加到 TreeSet 中，将会按排序规则进行放置
        迭代器按照同样的顺序访问元素
        tree 新增元素比 hash table 慢，但是比数组和链表快
         */
        sortedTreeSet.add("carl");
        sortedTreeSet.add("kevin");
        sortedTreeSet.add("ano");
        sortedTreeSet.add("pax");
        Iterator<String> sortIterator = sortedTreeSet.iterator();
        // 对元素进行遍历，输出的信息是以 String 的排序规则重排后的顺序
        sortIterator.forEachRemaining(log::info);

    }
}
