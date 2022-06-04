package com.angers.project.onjava8.compare;

import com.angers.project.onjava8.collections.CountMap;
import com.angers.project.onjava8.common.CommonUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : liuanglin
 * @date : 2022/6/4 17:01
 * @description : Map 的常用操作
 */
public class MapOps {
    public static void printKeys(Map<Integer,String> map){
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys : ");
        System.out.println(map.keySet());
    }
    public static void test(Map<Integer,String> map){
        CommonUtils.printDivide(map.getClass().getSimpleName());
        map.putAll(new CountMap(25));
        map.putAll(new CountMap(25));
        printKeys(map);
        System.out.print("Values : ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11) : " + map.containsKey(11));
        System.out.println("map.get(11) : " + map.get(11));
        System.out.println("map.containsValue(\"F0\") : " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        System.out.println("First Key : " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty() : " + map.isEmpty());
        map.putAll(new CountMap(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty() : " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
    }
}
