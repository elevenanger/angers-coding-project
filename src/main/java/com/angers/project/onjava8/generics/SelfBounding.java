package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 19:06
 */
public class SelfBounding <T extends SelfBounding<T>>{
    T element;

    public T getElement() {
        return element;
    }

    public SelfBounding<T> setElement(T element) {
        this.element = element;
        return this;
    }

    public static void main(String[] args) {
        A a = new A();
        a.setElement(new A());
        a = a.setElement(new A()).getElement();
        a = a.getElement();
        C c = new C();
        c = c.setAndGet(new C());
    }
}

class A extends SelfBounding<A> {}

class B extends SelfBounding<A> {}

class C extends SelfBounding<C> {
    C setAndGet(C arg) {
        setElement(arg);
        return getElement();
    }
}

class D {}
