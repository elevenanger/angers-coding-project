package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 14:19
 * @description : 异常-自定义异常，添加更多的构造函数成员
 */
public class MyException2 extends Exception{
    private int x;
    MyException2(){}
    MyException2(String msg){
        super(msg);
    }

    public MyException2(String message, int x) {
        super(message);
        this.x = x;
    }
    public int val(){return x;}

    @Override
    public String toString() {
        return "MyException2{" +
                "message=" + super.getMessage() +
                "x=" + x +
                '}';
    }
}

class ExtraFeatures {
    static void f() throws MyException2 {
        System.out.println("Throw MyException2 From f()" );
        throw new MyException2();
    }
    static void g() throws MyException2 {
        System.out.println("Throw MyException2 From g()" );
        throw new MyException2("Originated from g()");
    }
    static void h() throws MyException2 {
        System.out.println("Throw MyException2 From h()" );
        throw new MyException2("Originated from h()",93);
    }

    public static void main(String[] args) {
        try {
            f();
        }catch (MyException2 e){
            e.printStackTrace(System.err);
        }
        try {
            g();
        }catch (MyException2 e){
            e.printStackTrace(System.err);
        }
        try {
            h();
        }catch (MyException2 e){
            e.printStackTrace(System.err);
            System.out.println(e.val());
        }
    }
}