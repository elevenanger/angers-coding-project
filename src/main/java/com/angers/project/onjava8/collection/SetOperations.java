package com.angers.project.onjava8.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : liuanglin
 * @date : 2022/4/19 11:20
 * @description : 集合-set-常用操作
 */
public class SetOperations {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1,"A B C D E F G H I J K L".split(" "));
        set1.add("M");
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2,"H I J K L".split(" "));
        System.out.println("set1.containsAll(set2) " + set1.containsAll(set2));
        set1.removeAll(set2);
        System.out.println("set1.removeAll(set2) "+ set1);
        Collections.addAll(set1,"X Y Z".split(" "));
        System.out.println("Collections.addAll(set1,\"X Y Z\".split(\" \")) " + set1);
    }
}
