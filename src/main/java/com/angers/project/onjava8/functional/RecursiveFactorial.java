package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 10:32
 * @description : 函数-递归-阶乘
 */
public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        /*
        n ==0 终止条件
        所有的递归函数都要有终止条件，不然就会进入无限循环
         */
        fact = n -> n==0?1:n* fact.call(n-1);
        for (int i = 0; i < 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}

interface IntCall {
    int call(int args);
}