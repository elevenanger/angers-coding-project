package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/5 19:53
 * @description : 字符串运算符
 * @apiNote 如果一个表达式以字符串开头，后面所有的操作数都必须是字符串
 */
public class StringOperators {

    public static void main(String[] args) {

        int x = 0, y = 1 , z = 2;
        String s = "x + y + z" ;
        // s 后面的操作数都会被编译器转换为字符串
        System.out.println( s + x + y + z);
        // x 会被转换为字符串
        System.out.println( x + "" + s);
        // 非字符串开头，字符串之前的表达式正常运算,字符串之后的操作数将会被转换为字符串
        System.out.println( x + y + z + "" + s + x + y + z);
        s += " (summed) = "; // 字符串连接
        System.out.println(s + (x + y + z)); // 括号控制运算顺序，在转换之前先完成计算
        System.out.println( "" + x); // toString 简写
    }
}
