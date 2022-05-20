package com.angers.project.onjava8.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/5/19 08:45
 * @description : 并发-构造函数中的共享参数
 */
interface SharedArg {
    int get();
}

class Unsafe implements SharedArg {
    private int id = 0;

    @Override
    public int get() {
        return id ++ ;
    }
}

class Safe implements SharedArg {
    private static AtomicInteger counter = new AtomicInteger();

    @Override
    public int get() {
        return counter.getAndIncrement();
    }
}

class SharedUser implements HasId {
    private final int id;

    public SharedUser(SharedArg sa) {
        this.id = sa.get();
    }

    @Override
    public int getId() {
        return id;
    }
}

class SyncConstructor implements HasId {
    private final int id;
    private static Object constructorLock = new Object();
    SyncConstructor(SharedArg sa){
        /*
        使用 synchronized 关键字变相为构造函数加锁确保线程安全
         */
        synchronized (constructorLock){
            id = sa.get();
        }
    }

    @Override
    public int getId() {
        return id;
    }
}

final class SyncFactory implements HasId {
    private final int id;
    /*
    final 构造函数
    只使用 static 工厂方法创建对象实例
    工厂方法使用 synchronized
     */
    private SyncFactory(SharedArg sa){
        id = sa.get();
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * 使用 synchronized 工厂方法创建对象实例确保线程安全
     * @param sa SharedArg 对象
     * @return SynFactory 对象
     */
    public static synchronized SyncFactory factory(SharedArg sa){
        return new SyncFactory(sa);
    }
}
public class SharedConstructorArguments {
    public static void main(String[] args) {
        Unsafe unsafe = new Unsafe();
        IdChecker.test(() -> new SharedUser(unsafe));
        Safe safe = new Safe();
        IdChecker.test(() -> new SharedUser(safe));
        /*
        output
        45856
        0

        SharedArg 是否线程安全取决于它的具体实现
        在 SharedUser 的构造函数中传入 SharedArg 对象作为参数
        可能会导致冲突
        要确保线程安全 SharedUser 构造函数需要对此进行控制
         */


        Unsafe unsafe1 = new Unsafe();
        IdChecker.test(() -> new SyncConstructor(unsafe1));
        /*
        output : 0
         */

        Unsafe unsafe2 = new Unsafe();
        IdChecker.test(()->SyncFactory.factory(unsafe2));
        /*
        output : 0
         */
    }
}
