package com.angers.project.onjava8.functional;

import java.util.function.BiConsumer;

/**
 * @author : liuanglin
 * @date : 2022/4/21 10:02
 * @description : 函数-利用自动装箱和拆箱机制在接口中使用基元类型参数
 */
public class BiConsumerPermutations {
    static BiConsumer<Integer,Double> biConsumer = (i,d) -> System.out.format("%d,%f%n",i,d);
    static BiConsumer<Double,Integer> biConsumer1 = (d,i) -> System.out.format("%d,%f%n",i,d);
    static BiConsumer<Integer,Long> biConsumer2 = (i,l) -> System.out.format("%d,%d%n",i,l);
    public static void main(String[] args) {
        biConsumer.accept(1,2.0d);
        biConsumer1.accept(3.0d,2);
        biConsumer2.accept(3,1L);
    }
}

