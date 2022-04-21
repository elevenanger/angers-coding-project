package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 10:48
 * @description : 函数-递归-斐波拉契数列
 * 斐波拉契数列，当前序列是数列中前两个数的和
 */
public class RecursiveFibonacci {
    IntCall fib;
    RecursiveFibonacci(){
        fib = n -> {
            switch (n){
                case 0 : return 0;
                case 1 : return 1;
                default: return fib.call(n-1) + fib.call(n-2);
            }
        };
    }
    int fibonacci (int i) {
        return fib.call(i);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(rf.fibonacci(i));
        }
    }
}
