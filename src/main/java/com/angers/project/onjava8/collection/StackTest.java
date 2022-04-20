package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : liuanglin
 * @date : 2022/4/19 10:48
 * @description : 集合-后进先出栈
 */
public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s: "we are the world".split(" ")) {
            stack.push(s);
        }
        stack.forEach(v -> System.out.print(v + " "));
        CommonUtils.printDivideLine("stack");
        Stack<String> stringStack = new Stack<>();
        for (String s: "we are the world".split(" ")) {
            stringStack.push(s);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }
}
