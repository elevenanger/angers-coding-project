package com.angers.project.onjava8.generics;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/6 08:18
 * @description :泛型-事项栈存储
 */
public class LinkedStack<T> {
    /*
    存储栈元素的节点
     */
    private static class Node<U> {
        U item;
        Node<U> next;
        public Node() {
            item = null;
            next = null;
        }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
    /*

     */
    private Node<T> top = new Node<>();

    /**
     * 往栈中新增元素
     * @param item 入栈元素
     */
    public void push(T item){
        top = new Node<>(item,top);
    }

    /**
     * 从栈中取出元素
     * 后进先出
     * @return 栈元素
     */
    public T pop() {
        T result = top.item;
        if (!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> strings = new LinkedStack<>();
        Arrays.stream("we are the world".split(" "))
                .forEach(strings::push);
        String s;
        while ((s = strings.pop()) != null)
            System.out.println(s);
    }
}