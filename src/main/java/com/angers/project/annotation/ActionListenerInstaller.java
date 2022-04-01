package com.angers.project.annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {

    /**
     * 处理传入对象中的 ActionListenerFor 注解
     * 枚举传入对象的所有方法
     * 分析是否存在 ActionListenerFor 注解，并为注解方法安装 ActionListener
     * @param o 可能存在 ActionListenerFor 注解方法的对象
     */
    public static void processAnnotations(Object o){
        try {
            Class<?> cl = o.getClass();
            for (Method m: cl.getDeclaredMethods()) { // 遍历传入对象类的所有方法
                // 是否存在 ActionListenerFor 注解
                ActionListenerFor actionListenerFor = m.getAnnotation(ActionListenerFor.class);
                if (actionListenerFor != null){
                    /*
                    存在 ActionListenerFor 注解的域
                    注解域的名称保存在 actionListenerFor.source() 方法
                     */
                    Field field = cl.getDeclaredField(actionListenerFor.source());
                    field.setAccessible(true);
                    addListener(field.get(o),o,m);
                }
            }
        }catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加调用给定方法的 action listener
     * @param source 将 action listener 添加到注解域
     * @param param listener 调用方法的隐式参数（存在该注解的对象类）
     * @param m listener 调用的方法
     * @throws ReflectiveOperationException 反射异常
     */
    public static void addListener(Object source, final Object param, final Method m)
        throws ReflectiveOperationException
    {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method me, Object[] args) throws Throwable {
                return m.invoke(param);
            }
        };

        /*
        为每一个注解的方法，构建一个 proxy 对象
        实现 ActionListener 接口
        并使用 actionPerformed 方法调用带注解的方法
         */
        Object listener = Proxy.newProxyInstance(null,
            new Class[]{ java.awt.event.ActionListener.class},handler);

        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);

        adder.invoke(source,listener);
    }

}
