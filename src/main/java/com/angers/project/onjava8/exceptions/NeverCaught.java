package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 18:32
 * @description :异常-无需捕获的异常
 */
public class NeverCaught {
    static void f(){
        /*
        RuntimeException 不需要方法上面添加异常签名
        也不需要在程序中抛出这种异常
        这属于未检查的异常
        意味着程序 bug
         */
        throw new RuntimeException();
    }
    static void g(){
        f();
    }
    public static void main(String[] args) {
        g();
    }
}
