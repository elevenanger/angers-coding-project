package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/4 18:19
 * @description : 移位运算符，只能用于基元整数类型
 */
public class ShiftOperators {

    public static void main(String[] args) {
        int i = 4;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        //左移运算符 (<<) 向左移运算符右侧指定的位数后生成运算符左侧的操作数（在低位插入零）
        i <<= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i = 4;
        /*
        右移运算符 (>>)
        如果操作数为正数
        将操作数向右移动运算符右侧指定的位数（高位插入0）
         */
        i >>= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i = 4;
        // 使用零扩展：无论符号如何，在高位插入零
        i >>>= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i = -4;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i <<= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i = -4;
        /*
        如果操作数为负数，在高位插入1
         */
        i >>= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
        i = -4;
        i >>>= 2;
        System.out.println(i + ":" + Integer.toBinaryString(i));
    }
}
