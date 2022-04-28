package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/27 09:43
 * @description : 校验-动态测试-排除不允许的字符
 */
public class Inverter4 implements StringInverter{
    static final String ALLOWED =
            "abcdefghijklmnopqrstuvwxyz ,." +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Override
    public String invert(String str) {

        if (str.length() > 30)
            throw new RuntimeException("argument too long");
        String result= "";
        for (char c : str.toCharArray()) {
            if (ALLOWED.indexOf(c) == -1)
                throw new RuntimeException(c + "Not Allowed");
            result += Character.isUpperCase(c)?
                    Character.toLowerCase(c):
                    Character.isUpperCase(c);
        }
        return result;
    }
}
