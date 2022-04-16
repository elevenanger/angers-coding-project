package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 21:11
 * @description : 内部类-回调
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);
        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallbackRef());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}

interface Incremental {
    void increment();
}

// 直接实现接口
class Callee1 implements Incremental {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }

}

class MyIncrement {
    public void increment(){
        System.out.println("other operation");
    }
    static void f(MyIncrement myIncrement){
        myIncrement.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    // 在内部类中实现接口
    private class Closure implements Incremental {
        @Override
        public void increment() {
            // 指定外部类的方法，不然会陷入死循环
            Callee2.this.increment();
        }
    }
    Incremental getCallbackRef(){
        return new Closure();
    }
}

class Caller {
    private Incremental callbackRef;

    public Caller(Incremental callbackRef) {
        /*
        Caller 在构造函数中持有 Incremental 对象的引用
        可以在一段时间之后使用该对象回调 Callee 类
         */
        this.callbackRef = callbackRef;
    }

    void go(){
        // 使用对象的引用回调 Callee 类
        callbackRef.increment();
    }
}

