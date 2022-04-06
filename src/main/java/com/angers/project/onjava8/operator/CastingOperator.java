package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/5 20:12
 * @description : 转换表达式，将一个类型的值或者对象转换成另一个类型 (type) 括号围绕被转换的数据类型
 * @apiNote 扩大转换：被转换的数据类型比转换的数据类型能够容纳更多的信息
 * @apiNote 缩小转换：被转换的数据类型比转换的数据类型容纳更少的信息
 * @apiNote 除了 boolean 值，Java 的其它基元类型之间都可以互相转换
 */
public class CastingOperator {

    public static void main(String[] args) {
        int i = 110;
        long il = (long) i; // 扩大转换（long）是非必要的，编译器会自动完成转换
        System.out.println(il);
        float ifl = (float) i;
        System.out.println(ifl);
        int j = (int) il; // 缩小转换，（int）是必须的，需要显示声明转换操作符
        System.out.println(j);
        /*
        缩小转换可能伴随着信息丢失
        float 或者 double 转换成 int
        小数点后面的数字会截断
        不会四舍五入
         */
        float fl = 3.23F;
        int fli = (int) fl;
        System.out.println(fli);
        fl = 4.98F;
        fli = (int) fl;
        System.out.println(fli);
        // 使用 Math.round（）可以进行四舍五入的操作
        fli = Math.round(fl);
        System.out.println(fli);
    }
}
