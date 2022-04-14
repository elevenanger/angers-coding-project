package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 19:27
 * @description : 接口-实现具有 default 方法的接口
 */
public class Implementation2 implements InterfaceWithDefault{
    @Override
    public void first() {
        System.out.println("Implementation2.first()");
    }

    @Override
    public void second() {
        System.out.println("Implementation2.second()");
    }

    public static void main(String[] args) {
        Implementation2 implementation2 = new Implementation2();
        implementation2.first();
        implementation2.second();
        implementation2.newMethod();
        /*
        output:
        Implementation2.first()
        Implementation2.second()
        InterfaceWithDefault.newMethod()
         */
    }
}
