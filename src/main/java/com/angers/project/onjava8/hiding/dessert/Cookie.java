package com.angers.project.onjava8.hiding.dessert;

/**
 * @author : liuanglin
 * @date : 2022/4/10 16:21
 * @description : 曲奇
 */
public class Cookie {

    /**
     * 构造函数
     */
    public Cookie(){
        System.out.println("This is a Cookie !");
    }

    /**
     * 方法，没有访问修饰符，默认只有包访问权限
     */
    void bite(){
        System.out.println(" bite ");
    }

    /**
     * protected 修饰方法
     * 具有 package 访问权限以及所有继承该方法的类的访问权限
     */
    protected void normalBite(){
        System.out.println("normal bite for Cookie family.");
    }
}
