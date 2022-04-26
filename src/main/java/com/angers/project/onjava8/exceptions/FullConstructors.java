package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 08:45
 * @description : 异常-为异常类定义构造函数以接收额外的参数
 */
public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            FullConstructors.f();
        }catch (MyException e){
            // 打印到达异常发生点的方法调用序列
            e.printStackTrace(System.out);
        }
        try {
            FullConstructors.g();
        }catch (MyException e){
            // 不带参数即默认输出至 System.err
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {
    // 无参构造函数
    public MyException() {}
    // 传入描述信息
    public MyException(String message) {
        super(message);
    }
}
