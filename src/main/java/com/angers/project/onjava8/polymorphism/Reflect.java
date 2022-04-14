package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/13 12:16
 * @description : java 反射机制
 */
public class Reflect {
    public static void main(String[] args) {
        Useful [] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f(); // ok
        x[0].g(); // ok
        // 向下转型，ClassCastException
        ((MoreUseful)x[0]).u();
        ((MoreUseful)x[0]).v();
        /*
        output:
        Exception in thread "main" java.lang.ClassCastException: com.angers.project.onjava8.polymorphism.Useful cannot be cast to com.angers.project.onjava8.polymorphism.MoreUseful
	    at com.angers.project.onjava8.polymorphism.Reflect.main(Reflect.java:16)
         */
    }
}

class Useful {
    public void f(){}
    public void g(){}
}

class MoreUseful extends Useful {
    @Override
    public void f() {}

    @Override
    public void g() {}

    public void u(){}

    public void v(){}
}