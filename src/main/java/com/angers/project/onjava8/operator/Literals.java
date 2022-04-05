package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/4 16:30
 * @description : 当将文字值插入程序时，编译器确切地知道要创建什么类型
 * 当类型不明确时，必须通过以与字面值关联的字符形式添加一些额外信息来引导编译器
 */
public class Literals {

    public static void main(String[] args) {
        int i1 = 0x2f; // 十六进制 （小写）
        System.out.println("i1: " + i1 +" : " + Integer.toBinaryString(i1));
        int i2 = 0x2F; // 十六进制 （大写）
        System.out.println("i2: " + i2 +" : " + Integer.toBinaryString(i2));
        int i3 = 0177; // 八进制 （前导零）
        System.out.println("i3: " + i3 +" : " + Integer.toBinaryString(i3));
        char c = 0xffff; // 最大字符十六进制值
        System.out.println("c: " + c +" : " + Integer.toBinaryString(c));
        byte b = 0x7f; // 最大字节十六进制值 10101111
        System.out.println("b: " + b +" : " + Integer.toBinaryString(b));
        short s = 0x7fff; // 最大 short 十六进制值
        System.out.println("s: " + s +" : " + Integer.toBinaryString(s));
        long n1 = 200L; // long 后缀 L
        System.out.println("n1: " + n1 );
        long n2 = 200l; // long 后缀 l （会产生疑惑）
        System.out.println("n2: " + n2 );
        long n3 = 200; // long 无后缀
        System.out.println("n3: " + n3 );
        // java 7 二进制表达字面量
        byte blb = (byte) 0b00110101;
        System.out.println("blb: " + blb +" : " + Integer.toBinaryString(blb));
        short bls = (short) 0B00101111110101111;
        System.out.println("bls: " + bls +" : " + Integer.toBinaryString(bls));
        int bli = 0b00101111101011111010111110101111;
        System.out.println("bli: " + bli +" : " + Integer.toBinaryString(bli));
        long bll = 0b00101111101011111010111110101111;
        System.out.println("bll: " + bll + ": " + Long.toBinaryString(bll));
        float f1 = 1;
        System.out.println("f1: " + f1 + ": " + Float.toHexString(f1));
        float f2 = 1F;
        System.out.println("f2: " + f2 + ": " + Float.toHexString(f2));
        float f3 = 1f;
        System.out.println("f3: " + f3 + ": " + Float.toHexString(f3));
        double d1 = 1d;
        System.out.println("d1: " + d1 + ": " + Double.toHexString(d1));
        double d2 = 1D;
        System.out.println("d2: " + d2 + ": " + Double.toHexString(d2));
        double d3 = 1;
        System.out.println("d3: " + d3 + ": " + Double.toHexString(d3));

    }
}
