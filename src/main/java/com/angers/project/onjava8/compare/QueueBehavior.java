package com.angers.project.onjava8.compare;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/6/3 17:37
 * @description : 队列
 */
public class QueueBehavior {
    static Stream<String> strings() {
        return Arrays.stream(("A B D C E F G H I J K").split(" "));
    }
    static void test(int id, Queue<String> queue){
        System.out.print(id + " : ");
        strings().map(queue::offer).count();
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int count = 11;
        test(1,new LinkedList<>());
        test(2,new PriorityQueue<>());
        test(3,new ArrayBlockingQueue<>(count));
        test(4,new ConcurrentLinkedQueue<>());
        test(5,new LinkedBlockingQueue<>());
        test(6,new PriorityBlockingQueue<>());
        test(7,new ArrayDeque<>());
        test(8,new ConcurrentLinkedDeque<>());
        test(9,new LinkedBlockingDeque<>());
        test(10,new LinkedTransferQueue<>());
        test(11,new SynchronousQueue<>());
    }
}
