package com.angers.project.onjava8.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/4 13:43
 * @description :反射-动态代理
 */
public class SimpleDynamicProxy {
    /**
     * 传入 SPInterface 接口对象，调用对象类实现的方法
     * @param spInterface 接口对象
     */
    public static void consumer(SPInterface spInterface) {
        spInterface.doSomething();
        spInterface.somethingElse("bla");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        /*
        创建一个动态 proxy 实例
        需要一个类加载器（使用已装载的对象的类）
        一组需要实现的接口
        以及一个 InvocationHandler 接口的实现
         */
        SPInterface proxy = (SPInterface) Proxy.newProxyInstance(
                SPInterface.class.getClassLoader(),
                new Class[]{SPInterface.class},
                new DynamicProxyHandler(realObject));
        consumer(proxy);
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     *
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return 对象
     * @throws Throwable 抛出异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" proxy " + proxy.getClass() +
                " , method " +  method.getName() +
                " , args " + args);
        if (args != null)
            Arrays.stream(args).forEach(System.out::println);
        return method.invoke(proxied,args);
    }
}