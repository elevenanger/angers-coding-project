package com.angers.project.onjava8.operator;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/5 19:06
 * @description : 位运算操作
 */
public class BitManipulation {

    /**
     * 带二进制补码形式打印 int 类型值
     * int 32 位
     * 负数：首位为 1
     * 正数: 首位为 0 ， 高位 0 不打印，直到第一位为 1
     * @param s 描述
     * @param i int 数值
     */
    static void printBinaryInt(String s, int i){
        System.out.println( s + ", int: " + i + ", Binary:\n  " +
                Integer.toBinaryString(i) + " length: " + Integer.toBinaryString(i).length());
    }

    /**
     * 带二进制补码形式打印 long 类型值
     * long 64 位
     * 负数 ：首位为 1
     * 正数: 首位为 0 ，高位 0 不打印，直到第一位为 1
     * @param s 描述
     * @param l long 数值
     */
    static void printBinaryLong(String s, long l){
        System.out.println( s + ", long: " + l + ", Binary:\n  " +
                Long.toBinaryString(l) + " length: " + Long.toBinaryString(l).length());
    }

    public static void main(String[] args) {
        Random random  = new Random(47);
        int i = random.nextInt(128);
        int j = random.nextInt(128);
        printBinaryInt("-1",-1);
        printBinaryInt("1",1);
        int maxPos = 2147483647;
        printBinaryInt("maxPos",maxPos);
        int maxNeg = -2147483647;
        printBinaryInt("maxNeg",maxNeg);
        printBinaryInt("i",i);
        printBinaryInt("~i",~i); // 非运算 1 转 0 ， 0 转 1
        printBinaryInt("-i",-i);
        printBinaryInt("j",j);
        printBinaryInt("i & j",i & j); // 和运算
        printBinaryInt("i | j",i | j); // 或运算
        printBinaryInt("i ^ j", i ^ j); // 异或 i 和 j 不同则为 1 ，相同则为 0
        printBinaryInt("i << 5", i << 5);
        printBinaryInt("i >> 5", i >> 5);
        printBinaryInt("~i >> 5", ~i >> 5);
        printBinaryInt("i >>> 5", i >>> 5);
        printBinaryInt("~i >>> 5", ~i >>> 5);

        long l = random.nextLong();
        long m = random.nextLong();
        printBinaryLong("-1L",-1L);
        printBinaryLong("1L",1L);
        long ll = 9223372036854775807L;
        printBinaryLong("maxPosLong" , ll);
        long lln = -9223372036854775807L;
        printBinaryLong("maxNegLong" , lln);
        printBinaryLong("l",l);
        printBinaryLong("~l",~l);
        printBinaryLong("-l",-l);
        printBinaryLong("m",m);
        printBinaryLong("l & m",l & m);
        printBinaryLong("l | m",l | m);
        printBinaryLong("l ^ m", l ^ m);
        printBinaryLong("l << 5", l << 5);
        printBinaryLong("l >> 5", l >> 5);
        printBinaryLong("~l >> 5", ~l >> 5);
        printBinaryLong("l >>> 5", l >>> 5);
        printBinaryLong("~l >>> 5", ~l >>> 5);
    }

}
