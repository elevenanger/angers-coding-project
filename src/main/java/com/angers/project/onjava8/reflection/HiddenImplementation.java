package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.reflection.interfacea.A;
import com.angers.project.onjava8.reflection.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * @author : liuanglin
 * @date : 2022/5/5 17:59
 * @description : 使用反射调用隐藏的方法
 */
public class HiddenImplementation {
    /**
     * 调用隐藏方法
     * @param a 对象
     * @param methodName 对象中的方法名
     * @throws Exception
     */
    static void callHiddenMethod(Object a,String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true); // 更改方法的访问权限
        g.invoke(a);
    }
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }
}
