package com.angers.project.onjava8.reflection;

/**
 * @author : liuanglin
 * @date : 2022/5/4 13:11
 * @description : 反射-代理
 */
public class SimpleProxyDemo {
    static void consumer(SPInterface spInterface){
        spInterface.doSomething();
        spInterface.somethingElse("bla");
    }
    public static void main(String[] args) {
        SimpleProxyDemo.consumer(new RealObject());
        SimpleProxyDemo.consumer(new SimpleProxy(new RealObject()));
    }
}

interface SPInterface {
    void doSomething();

    void somethingElse(String ars);
}

class RealObject implements SPInterface {
    @Override
    public void doSomething() {
        System.out.println("RealObject.doSomething()");
    }

    @Override
    public void somethingElse(String ars) {
        System.out.println("RealObject.somethingElse()");
    }
}
class SimpleProxy implements SPInterface {
    private SPInterface proxied;

    /**
     * 代理类构造函数
     * @param proxied 被代理的对象
     */
    public SimpleProxy(SPInterface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        // 代理额外的行为
        System.out.println("SimpleProxy.doSomething()");
        // 被代理对象的行为
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String ars) {
        System.out.println("SimpleProxy.somethingElse() " + ars);
        proxied.somethingElse(ars);
    }
}