package com.angers.project.onjava8.compare;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/6/3 20:28
 * @description : Deque 和队列类似，但是可以从任意一段添加和删除元素
 */
class CountString implements Supplier<String> {
    private int n = 0;

    public CountString() {
    }

    public CountString(int n) {
        this.n = n;
    }

    @Override
    public String get() {
        return Integer.toString(n ++ );
    }
}

public class SimpleDeque {
    static void test(Deque<String> deque){
        CountString s1 = new CountString();
        CountString s2 = new CountString(19);
        for (int i = 0; i < 8; i++) {
            // 往两端新增元素
            deque.offerFirst(s1.get());
            deque.offerLast(s2.get());
        }
        System.out.println(deque);
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()){
            // 从两端取出元素
            System.out.print(deque.peekFirst()+ " ");
            result.append(deque.pollFirst()).append(" ");
            System.out.print(deque.peekLast() + " ");
            result.append(deque.pollLast()).append(" ");
        }
        System.out.println("\n" + result);
    }

    public static void main(String[] args) {
        int count = 10;
        CommonUtils.printDivide("LinkedList");
        test(new LinkedList<>());
        CommonUtils.printDivide("ArrayDeque");
        test(new ArrayDeque<>());
        CommonUtils.printDivide("LinkedBlockingDeque");
        test(new LinkedBlockingDeque<>(count));
        CommonUtils.printDivide("ConcurrentLinkedDeque");
        test(new ConcurrentLinkedDeque<>());
    }
}