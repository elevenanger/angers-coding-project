package com.angers.project.onjava8.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : liuanglin
 * @date : 2022/5/5 08:48
 * @description :反射-通过动态代理对方法进行过滤特殊处理
 */
public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodsSelector(new Implementation())
        );
        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting();
    }
}
class MethodsSelector implements InvocationHandler {
    private Object proxied;

    public MethodsSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
        过滤方法
        对于满足条件的方法进行特殊处理
         */
        if (method.getName().equals("interesting"))
            System.out.println("find something interesting");
        return method.invoke(proxied,args);
    }
}
interface SomeMethods {
    void boring1();
    void boring2();
    void interesting();
    void boring3();
}
class Implementation implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1()");
    }

    @Override
    public void boring2() {
        System.out.println("boring2()");
    }

    @Override
    public void interesting() {
        System.out.println("interesting()");
    }

    @Override
    public void boring3() {
        System.out.println("boring3()");
    }
}