package com.angers.project.onjava8.concurrent;

/**
 * @author : liuanglin
 * @date : 2022/6/6 08:25
 * @description :
 */
public class ReOrdering implements Runnable{
    int one;
    int two;
    int three;
    int four;
    int five;
    int six;
    volatile int volaTile;
    @Override
    public void run() {
        /*
        在不改变最终结果的前提下
        Java 可能改变指令的顺序
        也就是说
        one = 1;
        two = 2;
        three = 3;
        三行指令的顺序可能会发生改变
        int x = four;
        int y = five;
        int z = six;
        这三行指令的顺序也可能会发生变化
        可能会导致出现问题
        volatile 可以防止类似的问题发生
        volatile 变量之前的指令会在 volatile 变量之前完成
        volatile 变量之后的指令会在 volatile 执行结束之后发生
         */
        one = 1;
        two = 2;
        three = 3;
        volaTile = 93;
        int x = four;
        int y = five;
        int z = six;
    }
}
