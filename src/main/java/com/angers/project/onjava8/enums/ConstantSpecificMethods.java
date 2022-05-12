package com.angers.project.onjava8.enums;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/11 10:13
 * @description : 枚举-特定于常量的方法
 */
public enum ConstantSpecificMethods {
    A{
        @Override
        void getInfo() {
            System.out.println("A.getInfo()");
        }
    },
    B{
        @Override
        void getInfo() {
            System.out.println("B.getInfo()");
        }
    },
    C{
        @Override
        void getInfo() {
            System.out.println("C.getInfo()");
        }
    };

    /**
     * Java 枚举可以通过为枚举类型中添加方法给每一个枚举类型实例添加不同的行为
     * 在枚举类中定义抽象方法
     * 各个枚举实例实现该抽象方法
     */
    abstract void getInfo();

    public static void main(String[] args) {
        Arrays.stream(ConstantSpecificMethods.values())
                .forEach(ConstantSpecificMethods::getInfo);
    }
}
