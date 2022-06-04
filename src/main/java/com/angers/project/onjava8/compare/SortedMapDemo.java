package com.angers.project.onjava8.compare;

import com.angers.project.onjava8.collections.CountMap;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author : liuanglin
 * @date : 2022/6/4 17:15
 * @description : 排序 Map 的特性
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> sortedMap =
                new TreeMap<>(new CountMap(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        Iterator<Integer> iterator =
                sortedMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = iterator.next();
            if (i == 6) high = iterator.next();
            else iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedMap.subMap(low,high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));
    }
}
