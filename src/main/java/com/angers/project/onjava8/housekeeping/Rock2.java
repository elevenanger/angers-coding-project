package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/6 18:43
 * @description : 通过传入参数构造对象
 */
public class Rock2 {

    /*
    如果这个带参数的构造函数 Rock2(int i) 是 Rock2 唯一的构造函数
    Java 编译器不允许再通过其它的方式构造该类对象
     */
    Rock2(int i) {
        System.out.println("Rock " + i +" ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Rock2(i);
        }
    }
}
