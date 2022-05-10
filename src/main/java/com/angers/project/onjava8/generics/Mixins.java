package com.angers.project.onjava8.generics;

import java.util.Date;

/**
 * @author : liuanglin
 * @date : 2022/5/9 19:48
 */
class Mixin extends BasicImp implements TimeStamped,SerialNumbered{
    /*
    混合-混合多个接口的特性
    在混合类中定义每个接口类型作为混合类中的一个实例域
    也使用了委派机制
    实现接口的方法，使用合适的对象调用对应的方法
     */
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    @Override
    public long getTimeStamp() {
        return timeStamp.getTimeStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}
interface TimeStamped {
    long getTimeStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }
}

interface SerialNumbered { long getSerialNumber();}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter ++ ;
    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);
    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}
public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test1");
        mixin2.set("test2");
        System.out.println(mixin1.get() + " " + mixin1.getTimeStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " " + mixin2.getTimeStamp() + " " + mixin2.getSerialNumber());
    }
}