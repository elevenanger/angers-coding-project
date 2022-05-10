package com.angers.project.onjava8.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/9 15:17
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        /*
        List 需要明确的类型信息
        如果类型信息不明确，无法安全地添加元素
         */
        List<? extends Fruit> fruits = new ArrayList<>();
//        fruits.add(new Orange());
//        fruits.add(new Jonathan())
        fruits.add(null);
        Fruit fruit = fruits.get(0);
    }
}
