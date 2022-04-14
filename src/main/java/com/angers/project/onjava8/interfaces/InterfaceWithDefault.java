package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 16:56
 * @description : 接口中定义 default 方法
 *
 * 所有使用该接口的类不受影响
 */
public interface InterfaceWithDefault {
    void first();
    void second();
    /*
    default 关键字允许在接口中实现方法
    default 方法允许在现有接口增加方法而不影响已经实现该接口的代码
    default 方法又称之为防御方法或者虚拟扩展方法
     */
    default void newMethod(){
        System.out.println("InterfaceWithDefault.newMethod()");
    }
}



