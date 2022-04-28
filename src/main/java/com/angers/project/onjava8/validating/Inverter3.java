package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/27 09:32
 * @description :验证-动态测试-大小写转换并确保字符串长度不超过 30
 */
public class Inverter3 implements StringInverter{

    @Override
    public String invert(String str) {
        if (str.length() > 30)
            throw new RuntimeException("argument too long");
        String result= "";
        for (char c : str.toCharArray()) {
            result += Character.isUpperCase(c)?
                    Character.toLowerCase(c):
                    Character.isUpperCase(c);
        }
        return result;
    }
}
