package com.angers.project.onjava8.strings;

/**
 * @author : liuanglin
 * @date : 2022/4/30 16:52
 * @description : 字符串-使用运算符拼接字符串
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        // 使用操作符进行字符串拼接，编译器会使用 StringBuilder 对字符串拼接
        String s = mango + " price:" + "15";
        System.out.println(s);
    }
}
