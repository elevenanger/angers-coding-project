package com.angers.project.onjava8.compare;

import com.angers.project.onjava8.collections.CountMap;

import java.util.LinkedHashMap;

/**
 * @author : liuanglin
 * @date : 2022/6/4 17:24
 * @description : LinkedHashMap 的一些特性
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> map =
                new LinkedHashMap<>(new CountMap(10));
        System.out.println(map);
        /*
        设置 map 的初始容量大小、负载系数以及是否使用LRU（最近最少使用）算法
         */
        map = new LinkedHashMap<>(16,0.75f,true);
        map.putAll(new CountMap(10));
        System.out.println(map);
        for (int i = 0; i < 6; i++) {
            map.get(i);
        }
        System.out.println();
        System.out.println(map);
        map.get(0);
        System.out.println(map);
    }
}
