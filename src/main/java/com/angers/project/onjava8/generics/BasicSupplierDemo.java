package com.angers.project.onjava8.generics;

import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/6 10:05
 */
public class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(BasicSupplier.create(CountedObject.class))
                .limit(20)
                .forEach(System.out::println);
    }
}