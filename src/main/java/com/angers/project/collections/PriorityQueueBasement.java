package com.angers.project.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 优先级队列
 * 以任意顺序插入元素后，按照排序后的顺序检索元素
 */
@Slf4j
public class PriorityQueueBasement{

    public static void main(String [] args){

        PriorityQueue<String> strings = new PriorityQueue<>();
        /*
        PriorityQueue 的元素类型必须是可排序的
        */
        strings.add("cat");
        strings.add("ant");
        strings.add("dog");
        Iterator<String> stringIterator = strings.iterator();
        // 迭代不会按顺序进行
        stringIterator.forEachRemaining(log::info);
        while (!strings.isEmpty()){
            /*
            每次 remove 操作都会移除顺位最小的元素
            PriorityQueue 这种机制特别适合用作任务编排
            最优先的任务最先出队
             */
            log.info(strings.remove());
        }
    }
}