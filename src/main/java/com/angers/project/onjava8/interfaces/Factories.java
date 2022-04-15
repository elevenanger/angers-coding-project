package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 16:29
 * @description : 接口-工厂方法设计模式
 * 相比于直接调用构造函数
 * 创建一个工厂类实现工厂接口
 * 在工厂类中定义工厂方法
 * 通过调用工厂类对象的方法返回返回实现特定接口的对象
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory){
        Service service = factory.getService();
        service.m1();
        service.m2();
    }
    public static void main(String[] args) {
        Factories.serviceConsumer(new Service1Factory());
        Factories.serviceConsumer(new Service2Factory());
        /* output:
        Service1.m1()
        Service1.m2()
        Service2.m1()
        Service2.m2()
         */
    }
}

interface Service {
    void m1();
    void m2();
}

interface ServiceFactory {
    Service getService();
}

class Service1 implements Service {
    @Override
    public void m1() {
        System.out.println(getClass().getSimpleName() + ".m1()");
    }

    @Override
    public void m2() {
        System.out.println(getClass().getSimpleName() + ".m2()");
    }
}

class Service1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Service1();
    }
}

class Service2 implements Service {
    @Override
    public void m1() {
        System.out.println(getClass().getSimpleName() + ".m1()");
    }

    @Override
    public void m2() {
        System.out.println(getClass().getSimpleName() + ".m2()");
    }
}

class Service2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Service2();
    }
}




