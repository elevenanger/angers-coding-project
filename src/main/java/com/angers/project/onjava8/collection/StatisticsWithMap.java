package com.angers.project.onjava8.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/19 13:32
 * @description : 集合-map-统计
 */
public class StatisticsWithMap {
    public static void main(String[] args) {
        Random random = new Random(93);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Integer num = random.nextInt(20);
            Integer count = map.get(num);
            map.put(num,count == null?1:count+1);
        }
        System.out.println(map);
    }
}
