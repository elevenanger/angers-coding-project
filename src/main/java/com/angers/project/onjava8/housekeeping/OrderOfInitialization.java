package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 15:04
 * @description : 通过 构造 House 对象查看对象和变量的构造顺序
 */
public class OrderOfInitialization {
    public static void main(String[] args) {
        // 实例域在方法调用之前完成初始化，即便是构造函数亦是如此
        House house = new House();
        house.f();

        House overloadedHouse  = new House(100);
        overloadedHouse.f();
    }
}
