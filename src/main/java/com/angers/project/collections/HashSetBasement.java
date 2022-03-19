package com.angers.project.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 集合是没有重复项的元素的合集
 * 只有在不关心元素在集合中的顺序的情况下使用 HashSet
 */
@Slf4j
public class HashSetBasement {

    public static  void main(String [] args){
        HashSet<String> words = new HashSet<>();
        long totalTime = 0;
        try(Scanner in = new Scanner(System.in)){
            while (in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word); // 只有在集合内不存在该元素才会被添加
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> stringIterator = words.iterator();
        for (int i = 1; i <=20 && stringIterator.hasNext() ; i++) {
            log.info(stringIterator.next());
        }

        log.info(words.size()+"distinct words. " + totalTime + " milliseconds. ");
    }
}
