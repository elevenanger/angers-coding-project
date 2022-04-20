package com.angers.project.onjava8.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : liuanglin
 * @date : 2022/4/19 10:54
 * @description : 集合-使用 ArrayDeque 实现 stack
 */
public class Stack <T> {
    private Deque<T> storage = new ArrayDeque<>();

    public void push(T v){
        storage.push(v);
    }
    public T peek() {
        return storage.peek();
    }
    public T pop() {
        return storage.pop();
    }
    public boolean isEmpty() {
        return storage.isEmpty();
    }
    @Override
    public String toString() {
        return storage.toString();
    }
}
