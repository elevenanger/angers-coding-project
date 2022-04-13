package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/12 18:01
 * @description : 尝试 Override 一个 private 方法
 */
public class PrivateOverride {
    private void f(){
        System.out.println("PrivateOverride.f()");
    }

    public static void main(String[] args) {
        /*
        private 方法是有一个隐式的 final 声明
        无法被覆盖
        使用派生类的引用向上转型赋值给基类
        基类对象调用的还是 private void f()
        派生类定义的方法避免和基类 private 方法使用相同的名称，虽然不会出现编译错误，但是以免引起混淆
         */
        PrivateOverride po = new Derived();
        po.f();
        Derived de = new Derived();
        de.f();
        /* output
        PrivateOverride.f()
        Derived.f()
         */
    }
}

class Derived extends PrivateOverride {
    public void f(){
        System.out.println("Derived.f()");
    }
}

