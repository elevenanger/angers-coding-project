package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 16:24
 * @description : 实现多个接口的两种方式
 */
public class MultiInterfaces {
    static void takeA (A a) {
        a.a();
    }
    static void takeB (B b) {
        b.b();
    }
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        MultiInterfaces.takeA(x);
        MultiInterfaces.takeA(y);
        MultiInterfaces.takeB(x);
        MultiInterfaces.takeB(y.makeB());
        /* output:
        X.a()
        Y.a()
        X.b()
        .b()
         */
    }
}

interface  A {
    default void a(){
        System.out.println(getClass().getSimpleName() + ".a()");
    }
}

interface B {
    default void b(){
        System.out.println(getClass().getSimpleName() + ".b()");
    }
}

// 常规的实现方式
class X implements A,B {}

class Y implements A {
    /*
    使用匿名内部类实现 B
     */
    B makeB (){
        return new B() {
            @Override
            public void b() {
                B.super.b();
            }
        };
    }
}