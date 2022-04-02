package com.angers.project.corejava.interfaces;

/**
 * 接口：需要实现接口的类的一组需求，符合接口定义的行为和方法
 * 用法：如果一个类符合特定的接口，则可以执行相应的服务
 * 接口可以有一个或者多个方法
 * 接口不能定义实例域，提供实例域以及其可以操作的方法是类的职责
 */
public interface Comparable {

    /**
     * 在 interface 中可以定义常量
     * 常量域都是 public static final 的，所以只需要定义 类型，域名和值即可
     */
    int RANK = 1;

    /**
     * 接口的方法都是 public 的，所以无需再在方法上声明 public
     * 任何实现 Comparable 接口的类，都必须要有 compareTo 方法
     * 类实现接口，需要满足以下条件：
     * 1.声明类实现接口，使用 implements 关键字
     * 2.实现对于接口中所有方法的定义
     */
    int compareTo(Object comparedObject);

    /**
     * default 方法，在 interface 中实现，可以调用其它的方法
     * default 方法还有一个比较重要的用途就是接口演进
     * 如果在接口中新增方法，使用 default 修饰符则之前实现该接口的类可以不修改代码平滑升级
     * 实现这个接口的类即可以选择重写或者直接使用该方法
     * @param otherObject 比较对象
     * @return 0 否  1 是
     */
    default boolean isSame(Object otherObject){
        return otherObject.getClass()==this.getClass();
    }

    public static void main(String [] args) {

    }

}