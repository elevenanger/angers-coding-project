package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.reflection.interfacea.A;

/**
 * @author : liuanglin
 * @date : 2022/5/5 16:33
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        if (a instanceof B){
            B b = (B) a;
            b.g();
        }
    }
}
class B implements A {
    @Override
    public void f() {}
    public void g() {}
}
