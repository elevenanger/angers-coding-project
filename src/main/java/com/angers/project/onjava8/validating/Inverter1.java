package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/27 09:31
 * @description : 验证-动态测试-不做任何操作，返回原字符串
 */
public class Inverter1 implements StringInverter{
    @Override
    public String invert(String str) {
        return str;
    }
}
