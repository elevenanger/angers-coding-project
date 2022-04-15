package com.angers.project.onjava8.interfaces;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/14 16:05
 * @description : 使用非常量初始化器在初始化接口中的域
 */
public interface RandVals {
    Random RANDOM = new Random(93);
    /*
    这些域不是接口的一部分
    它们的值存在接口的静态存储区域中
     */
    int RAND_INT = RANDOM.nextInt();
    double RAND_DOUBLE = RANDOM.nextDouble();
    long RAND_LONG = RANDOM.nextLong();
    float RAND_FLOAT = RANDOM.nextFloat();

    static void main(String[] args) {
        System.out.println(RandVals.RAND_DOUBLE);
        System.out.println(RandVals.RAND_FLOAT);
        System.out.println(RandVals.RAND_LONG);
        System.out.println(RandVals.RAND_INT);
    }
}
