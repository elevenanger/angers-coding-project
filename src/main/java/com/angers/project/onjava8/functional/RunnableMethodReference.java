package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 14:22
 * @description : 函数-Runnable 接口 run 方法的引用
 */
public class RunnableMethodReference {
    public static void main(String[] args) {
        /*
        匿名内部类实现
        需要实现接口中的方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();
        /*
        lambda 表达式实现
        定义方法体
         */
        new Thread(
                () -> System.out.println("lambda")
        ).start();
        /*
        使用相同方法签名的方法对接口方法进行赋值
         */
        new Thread(Go::go).start();
    }
}

class Go {
    static void go(){
        System.out.println("Go::go");
    }
}
