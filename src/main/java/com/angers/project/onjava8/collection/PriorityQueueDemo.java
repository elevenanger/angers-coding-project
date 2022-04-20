package com.angers.project.onjava8.collection;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/19 16:04
 * @description : 集合-队列-优先队列
 * 常规队列，先进先出
 * 优先级队列：最被需要的元素先出
 * 根据元素的优先级进行排序
 * 元素需要提供 Comparator
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        Random random = new Random(93);
        for (int i = 0; i < 20; i++) {
            priorityQueue.add(random.nextInt(i+10));
        }
        QueueDemo.printQ(priorityQueue);
        List<Integer> integers = Arrays.asList(12,23,44,21,65,87,22,10);
        priorityQueue = new PriorityQueue<>(integers.size(),Collections.reverseOrder());
        priorityQueue.addAll(integers);
        QueueDemo.printQ(priorityQueue);

        String fact = "NOTHING GONNA CHANGE IN MY LOVE";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPriorityQueue);
        stringPriorityQueue = new PriorityQueue<>(strings.size(),Collections.reverseOrder());
        stringPriorityQueue.addAll(strings);
        QueueDemo.printQ(stringPriorityQueue);

        Set<Character> characters = new HashSet<>();
        for (char c: fact.toCharArray()){
            characters.add(c);
        }
        PriorityQueue<Character> characterPriorityQueue = new PriorityQueue<>(characters);
        QueueDemo.printQ(characterPriorityQueue);
        characterPriorityQueue = new PriorityQueue<>(characters.size(),Collections.reverseOrder());
        characterPriorityQueue.addAll(characters);
        QueueDemo.printQ(characterPriorityQueue);
    }
}
