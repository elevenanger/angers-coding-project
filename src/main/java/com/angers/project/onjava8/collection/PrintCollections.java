package com.angers.project.onjava8.collection;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/18 16:35
 * @description : 集合-打印
 */
public class PrintCollections {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("rabbit");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat","Fuzzy");
        map.put("rabbit","Bid");
        map.put("dog","Boss");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedHashSet<>()));
        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
        /* output:
        [rat, rabbit, dog, dog]
        [rat, rabbit, dog, dog]
        [rat, rabbit, dog]
        [dog, rabbit, rat]
        [rat, rabbit, dog]
        {rat=Fuzzy, rabbit=Bid, dog=Spot}
        {dog=Spot, rabbit=Bid, rat=Fuzzy}
        {rat=Fuzzy, rabbit=Bid, dog=Spot}
         */
    }
}
