package com.angers.project.corejava.annotation;

import com.angers.project.onjava8.reflection.pets.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/4/19 13:57
 * @description : 集合-map-检索key或者value是否存在
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("my cat",new Cat("Molly"));
        petMap.put("my dog", new Dog("OldY"));
        petMap.put("my hamster",new Hamster("Boss"));
        System.out.println(petMap);
        Pet dog = petMap.get("my dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("my cat"));
        System.out.println(petMap.containsValue(dog));
    }
}
