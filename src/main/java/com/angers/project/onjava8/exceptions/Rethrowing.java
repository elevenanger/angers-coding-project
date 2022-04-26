package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 15:45
 * @description : 异常-重新抛出异常
 */
public class Rethrowing {
    static void f() throws Exception{
        throw new Exception("from f()");
    }
    static void g() throws Exception {
        try {
            f();
        }catch (Exception e){
            System.out.println("inside g()");
            e.printStackTrace(System.err);
            throw e;
        }
    }
    static void h() throws Exception {
        try {
            g();
        }catch (Exception e){
            System.out.println("inside h()");
            e.printStackTrace(System.err);
            // 这一行会变成新的异常的起点
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            h();
        }catch (Exception e){
            System.out.println("main:printStackTrace");
            e.printStackTrace(System.out);
        }
    }
}
