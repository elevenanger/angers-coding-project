package com.angers.project.onjava8.enums;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/10 11:00
 * @description :
 */
public class EnumClass {
    public static void main(String[] args) {
        /*
        没居中的值可以自动按顺序转换成数组
        可以使用数组相关的方法进行操作
         */
        Arrays.stream(Shruberry.values())
                // ordinal 方法获取枚举值声明的顺序
                .peek(v -> System.out.println( v + " " + v.ordinal()))
                // name() 方法返回枚举声明的名称
                .peek(v -> System.out.println(v.name()))
                // getDeclaringClass() 返回声明该枚举值的类
                .peek(v -> System.out.println(v.getDeclaringClass()))
                .forEach(System.out::println);


    }
}

enum Shruberry{
    GROUND,
    CRAWLING,
    HANGING
        }