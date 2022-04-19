package com.angers.project.onjava8.collection;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/18 19:53
 * @description : List 的特性
 * 两种类型的 List：
 * 1、ArrayList 随机访问效率高，插入和删除的开销大
 * 2、LinkedList 顺序读效率高，随机读效率低，插入删除开销小
 */
public class ListFeatures {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Dog());
        pets.add(new Bird());
        pets.add(new Cat());
        pets.add(new Bird());
        pets.add(new Bird());
        System.out.println("1: " + pets);
        Dog dog = new Dog();
        pets.add(dog);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.indexOf(dog));
        pets.remove(dog);
        Pet p =pets.get(0);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        Pet gang = new Bird();
        System.out.println("index not exist object : pets.indexOf(gang) : " + pets.indexOf(gang));
        System.out.println("remove not exist object : pets.remove(gang) : " + pets.remove(gang));
        System.out.println("remove exist object : pets.remove(p)"+pets.remove(p));
        pets.add(1,new Bird());
        System.out.println("insert an index : " + pets);
        List<Pet> sub = pets.subList(1,4);
        System.out.println("sub list : " + sub);
        System.out.println("contain list : " + pets.containsAll(sub));
        Collections.sort(sub, Comparator.comparing(Pet::toString));
        System.out.println("sorted sublist : " + sub);
        System.out.println("order is not important in containsAll : " + pets.containsAll(sub));
        Random random = new Random(10);
        Collections.shuffle(sub,random);
        System.out.println("shuffled list : "+ sub);
        System.out.println(pets.containsAll(sub));
        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1),pets.get(3));
        System.out.println("sub : " + sub);
        copy.retainAll(sub); // 取交集
        System.out.println("retained list : " + copy);
        copy = new ArrayList<>(pets); // fresh copy
        copy.remove(2);
        System.out.println("remove by index : " + copy);
        copy.removeAll(sub);
        System.out.println("copy.removeAll(sub) : " + copy);
        copy.set(1,new Dog());
        System.out.println("replace one element : copy.set(1,new Dog()) : " + copy);
        copy.addAll(0,sub);
        System.out.println("insert into copy.addAll(0,sub) : " + copy);
        System.out.println("isEmpty ? " + pets.isEmpty());
        pets.clear();
        System.out.println("remove all elements pets.clear() " + pets.isEmpty());
        pets.addAll(copy);
        System.out.println(pets);
        Object [] objects = pets.toArray();
        System.out.println(objects[1]);
        // 如果数组参数太小不足以保存列表中的所有元素， toArray() 创建一个合适大小的新数组
        Pet [] pa = copy.toArray(new Pet[0]);
        System.out.println(pa[1]);
    }
}

abstract class Pet {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    abstract void call();
}

class Dog extends Pet {
    @Override
    void call() {
        System.out.println("wong");
    }
}

class Cat extends Pet {
    @Override
    void call() {
        System.out.println("mew");
    }
}

class Bird extends Pet {
    @Override
    void call() {
        System.out.println("Jiu");
    }
}