package com.angers.project.corejava.collections;

import com.angers.project.onjava8.reflection.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/4/19 14:02
 * @description : 列表 map
 */
public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
    static {
        petPeople.put(new Person("Wong"), Arrays.asList(new Cat("Bowl"),new Cymric("Bubble")));
        petPeople.put(new Person("Kevin"),Arrays.asList(new Hamster("BiBi"),new Cymric("Dar")));
    }

    public static void main(String[] args) {
        System.out.println("persons: " + petPeople.keySet());
        System.out.println("pets: " + petPeople.values());
        petPeople.forEach((k,v) -> {
            System.out.println(k + " has: ");
            v.forEach(System.out::println);
        });
    }
}
