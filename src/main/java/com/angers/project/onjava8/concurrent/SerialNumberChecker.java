package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author : liuanglin
 * @date : 2022/6/6 09:19
 * @description : 检查 SerialNumber 产生的序列号是否是线程安全的
 */
public class SerialNumberChecker implements Runnable{
    private CircularSet serials = new CircularSet(1000);
    private SerialNumbers producer;

    public SerialNumberChecker(SerialNumbers producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            int serial = producer.nextSerialNumber();
            if (serials.contains(serial)) {
                System.out.println("存在重复值 ： " + serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    static void test(SerialNumbers producer){
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(
                    new SerialNumberChecker(producer));
        }
        new Nap(4,"未发现重复数字");
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(new SerialNumbers());
        /* output :
        存在重复值 ： 502
        volatile 不能解决线程安全问题
         */
    }
}
