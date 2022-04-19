package com.angers.project.onjava8.collection;

import java.util.ArrayList;

/**
 * @author : liuanglin
 * @date : 2022/4/17 21:44
 * @description : 集合 - 使用泛型
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        // 只需要在左侧声明对象类型，右侧会根据左侧的对象类型进行类型推断
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

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}

class Orange {}