package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/6 18:37
 * @description : 使用构造器构造对象
 */
public class Rock {

    /*
    确保每个对象都有被正确的初始化
    Java 使用构造器来初始化对象
    对象创建时，Java 自动调用构造器
    构造器方法的名字和类名一样
    没有参数的构造器方法称为 零参数构造器 无参构造器
     */
    Rock(){
        System.out.println("Rock ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Rock();
        }
    }
}
