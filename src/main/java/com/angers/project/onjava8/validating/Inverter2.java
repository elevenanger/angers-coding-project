package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/27 09:39
 * @description : 校验-动态测试-大小写转换
 */
public class Inverter2 implements StringInverter{
    @Override
    public String invert(String str) {
        String result= "";
        for (char c : str.toCharArray()) {
            result += Character.isUpperCase(c)?
                    Character.toLowerCase(c):
                    Character.isUpperCase(c);
        }
        return result;
    }
}
