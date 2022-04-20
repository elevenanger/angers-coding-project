package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : liuanglin
 * @date : 2022/4/19 11:12
 * @description : 集合-set-排序
 */
public class SetOfStrings {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("blue");
            colors.add("orange");
            colors.add("white");
            colors.add("white");
            colors.add("black");
        }
        System.out.println(colors);
        CommonUtils.printDivideLine("TreeSet");
        colors = new TreeSet<>(); // TreeSet 会对 set 中的元素进行排序
        for (int i = 0; i < 100; i++) {
            colors.add("blue");
            colors.add("orange");
            colors.add("white");
            colors.add("white");
            colors.add("black");
        }
        System.out.println(colors);
    }
}
