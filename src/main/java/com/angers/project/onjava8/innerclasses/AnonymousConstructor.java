package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 12:17
 * @description : 为匿名内部类创建构造函数
 */
public class AnonymousConstructor {
    // 这里的 int i 不必为 final ，在它被传入内部类构造函数之前，没有直接被匿名内部类使用
    public static Base getBase(int i){
        return new Base(i) {
            {
                System.out.println("Inside instance initializer.");
            }
            @Override
            public void desc() {
                System.out.println("In Anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = AnonymousConstructor.getBase(10);
        base.desc();
    }
}

abstract class Base {
    Base(int i) {
        System.out.println(getClass().getSimpleName() + " " + i);
    }
    public abstract void desc();
}
