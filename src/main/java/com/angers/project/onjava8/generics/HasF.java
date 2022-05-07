package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/6 16:08
 */
public class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }
    public void manipulation(){
        obj.f();
    }

    public static void main(String[] args) {
        Manipulator<HasF> m = new Manipulator<>(new HasF());
        m.manipulation();
    }
}