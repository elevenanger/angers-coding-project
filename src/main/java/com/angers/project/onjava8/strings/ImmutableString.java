package com.angers.project.onjava8.strings;

/**
 * @author : liuanglin
 * @date : 2022/4/30 16:39
 * @description : 字符串-不可变性
 */
public class ImmutableString {
    /**
     * 将字符串转换成大写
     * @param s 源字符串
     * @return 转换后的字符串
     * Java 中对字符串的操作都是创建一个新的字符串并返回
     * 原始的字符串未做更改
     */
    static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String ori = "anger";
        String after = upcase(ori);
        System.out.println(ori);
        System.out.println(after);
    }
}
