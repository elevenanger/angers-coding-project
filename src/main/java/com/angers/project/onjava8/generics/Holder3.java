package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.reflection.pets.Cat;

/**
 * @author : liuanglin
 * @date : 2022/5/5 18:39
 * @description :泛型-类型占位符(<T>)定义参数类型
 */
public class Holder3 <T>{
    private T a;

    public Holder3() {}

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Cat> catHolder = new Holder3<>();
        catHolder.setA(new Cat());
        System.out.println(catHolder.getA());
    }
}
