package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/19 14:17
 * @description : 集合-队列
 * 队列是先进先出的模型
 */
public class QueueDemo {
    public static void printQ(Queue queue){
        queue.stream()
                .map(v -> v +=" ")
                .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(93);
        for (int i = 0; i < 100; i++) {
            queue.offer(random.nextInt(i+10));
        }
        printQ(queue);
        Queue<Character> characters = new LinkedList<>();
        for (char c : "Forever".toCharArray()){
            characters.offer(c);
        }
        printQ(characters);
    }

}

