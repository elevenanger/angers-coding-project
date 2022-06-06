package com.angers.project.onjava8.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : liuanglin
 * @date : 2022/6/6 09:35
 * @description : 使用原子类重写 SerialNumber
 */
public class AtomicSerialNumber extends SerialNumbers{
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public int nextSerialNumber() {
        return serialNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(new AtomicSerialNumber());
        /* output :
        未发现重复数字
         */
    }
}
