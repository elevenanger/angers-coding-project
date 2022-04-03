package com.angers.project.onjava8.operator;

public class DecAndInc {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("i = " + i);
        /*
        自增运算 ++ ：增加一个单元
        自减运算 -- ：减少一个单元
         */
        // 后缀：先产生结果，后进行运算，此时打印的数值为 1，运算后的结果为 2
        System.out.println("i++ = " + i++);
        // 前缀：先进行运算，后生成结果，运算结果为 3 ，打印数值为 3
        System.out.println("++i = " + ++i );
        System.out.println("i = " + i);
        System.out.println("i-- = " + i--);
        System.out.println("--i = " + --i );

        float y = 1;
        System.out.println("++y = " + ++y );

        char a = 'a';
        System.out.println("++a = " + ++a );

    }
}
