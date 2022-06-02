package com.angers.project.onjava8.compare;

/**
 * @author : liuanglin
 * @date : 2022/6/2 15:22
 * @description :
 */
public class StringHashCode {
    public static void main(String[] args) {
        /*
        不同的 String 对象中的字符完全相同
        指向的内存地址也是相同的
        所以它们的 hashCode 也是相等的
         */
        String hellos [] = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
