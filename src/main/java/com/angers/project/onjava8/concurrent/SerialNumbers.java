package com.angers.project.onjava8.concurrent;

/**
 * @author : liuanglin
 * @date : 2022/6/6 08:59
 * @description : 产生序列号
 */
public class SerialNumbers {
    /*
    使用 volatile 变量
     */
    private volatile int serialNumber = 0;
    public int nextSerialNumber(){
        return serialNumber ++ ;
    }
}

class SynchronizedSerialNumbers extends SerialNumbers{
    private int serialNumber = 0;

    /**
     * 使用 synchronized 方法
     * 确保方法的线程安全
     * 此处可以不再需要 volatile 变量
     * 因为 synchronized 已经可以确保 volatile 的行为
     * @return 序列号
     */
    @Override
    public synchronized int nextSerialNumber() {
        return serialNumber ++ ;
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(new SynchronizedSerialNumbers());
        /* output :
        未发现重复数字
         */
    }
}