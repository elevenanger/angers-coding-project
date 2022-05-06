package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/5 15:09
 * @description : 反射-使用动态代理创建 Optional 对象
 */
public class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }

    private class NRobot implements Null ,Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}

class NullRobot {
    /**
     * 创建一个实现了 Null 和 Robot 接口的 NullRobot 实例
     * @param type 需要创建的 Robot 类型类
     * @return NullRobot 实例
     */
    public static Robot newNullRobot (Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class,Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Stream.of(new SnowRobot("SnowBee"),
                newNullRobot(SnowRobot.class))
                .forEach(Robot::test);
    }
}
