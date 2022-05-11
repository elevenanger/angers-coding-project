package com.angers.project.onjava8.generics.decorator;

import java.util.Date;

/**
 * @author : liuanglin
 * @date : 2022/5/10 08:46
 * @description :泛型-装饰器设计模式
 * 装饰器设计模式使用分层对象来为对象动态地添加职责
 */
public class Decoration {
    public static void main(String[] args) {
        TimeStamped t1 = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        SerialNumbered s1 = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
    }
}

class Basic {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Decorator extends Basic {
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public String getValue() {
        return basic.getValue();
    }

    @Override
    public void setValue(String value) {
        basic.setValue(value);
    }
}

class TimeStamped extends Decorator {
    private final long timeStamp;

    public TimeStamped(Basic basic ) {
        super(basic);
        this.timeStamp = new Date().getTime();
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter ++ ;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}