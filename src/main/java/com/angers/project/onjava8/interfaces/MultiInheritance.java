package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 19:38
 * @description : 多重继承
 */
public class MultiInheritance {

    public static void main(String[] args) {
        MI mi = new MI();
        mi.first();
        mi.second();
        mi.third();
        /*
        output:
        One.first()
        Two.second()
        Three.third()
         */
    }
}

interface One {
    default void first(){
        System.out.println("One.first()");
    }
}

interface Two {
    default void second(){
        System.out.println("Two.second()");
    }
}

interface Three {
    default void third(){
        System.out.println("Three.third()");
    }
}

/*
可以实现多个接口，用 , 分隔
通过 default 方法，实现多个接口的类便组合了这些方法的行为
 */
class MI implements One,Two,Three {}