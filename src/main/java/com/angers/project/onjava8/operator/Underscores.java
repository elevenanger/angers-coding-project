package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/4 17:11
 * @description : 下划线
 * 可以在数字字面量中间增加下划线 _ ，方便阅读
 * 1.不能连续使用一个以上下划线
 * 2.不能在数字的开头和末尾使用下划线
 * 3.不能在后缀周围使用下划线 D/F/L
 * 4.不能在二进制或者十六进制标识符周围使用下划线 b/x
 */
public class Underscores {

    public static void main(String[] args) {
        double d = 232_232_434_232.562_12;
        System.out.println(d);
        int bin = 0b0010_1001_1100_1011_0110;
        System.out.println(bin + ":" + Integer.toBinaryString(bin));
        System.out.printf("%x%n" , bin);
        long hex = 0x7f_9e_2d;
        System.out.printf("%x%n" , hex);
    }
}
