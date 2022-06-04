package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/4 18:47
 * @description : 使用 Collections.synchronized 方法
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> collection =
                Collections.synchronizedCollection(
                        new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new TreeSet<>());
        Set<String> set1 = Collections.synchronizedSet(new HashSet<>());
        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map1 = Collections.synchronizedMap(new TreeMap<>());
    }
}
