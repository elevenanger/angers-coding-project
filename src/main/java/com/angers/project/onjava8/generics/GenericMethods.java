package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.reflection.pets.Cat;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:38
 * @description :泛型-使用泛型方法
 */
public class GenericMethods {
    /**
     * 泛型方法可以独立于类存在
     * 即不需要泛型类也可以定义泛型方法
     * 定义一个泛型方法，在返回值类型前面定义泛型标识 <T>
     * 使用泛型类，在初始化类对象的时候需要指定参数类型
     * 但是泛型方法不需要
     * 编译器会推断出来
     * @param t 泛型参数
     * @param <T> 泛型返回值
     */
    public <T> void f(T t){
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("hello");
        gm.f(new Cat());
        gm.f(10L);
        gm.f(1);
        gm.f(1.22f);
    }
}
