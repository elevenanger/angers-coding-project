package com.angers.project.onjava8.collection;

import java.util.ArrayList;

/**
 * @author : liuanglin
 * @date : 2022/4/17 21:44
 * @description :
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            apples.add(new Apple());
        }
        apples.stream()
                .map(Apple::getId)
                .forEach(System.out::println);
    }
}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long getId(){
        return id;
    }
}

class Orange {}