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
        List<Petty> petties = new ArrayList<>();
        petties.add(new Dog());
        petties.add(new Bird());
        petties.add(new Cat());
        petties.add(new Bird());
        petties.add(new Bird());
        System.out.println("1: " + petties);
        Dog dog = new Dog();
        petties.add(dog);
        System.out.println("2: " + petties);
        System.out.println("3: " + petties.indexOf(dog));
        petties.remove(dog);
        Petty p = petties.get(0);
        System.out.println("4: " + p + " " + petties.indexOf(p));
        Petty gang = new Bird();
        System.out.println("index not exist object : pets.indexOf(gang) : " + petties.indexOf(gang));
        System.out.println("remove not exist object : pets.remove(gang) : " + petties.remove(gang));
        System.out.println("remove exist object : pets.remove(p)"+ petties.remove(p));
        petties.add(1,new Bird());
        System.out.println("insert an index : " + petties);
        List<Petty> sub = petties.subList(1,4);
        System.out.println("sub list : " + sub);
        System.out.println("contain list : " + petties.containsAll(sub));
        Collections.sort(sub, Comparator.comparing(Petty::toString));
        System.out.println("sorted sublist : " + sub);
        System.out.println("order is not important in containsAll : " + petties.containsAll(sub));
        Random random = new Random(10);
        Collections.shuffle(sub,random);
        System.out.println("shuffled list : "+ sub);
        System.out.println(petties.containsAll(sub));
        List<Petty> copy = new ArrayList<>(petties);
        sub = Arrays.asList(petties.get(1), petties.get(3));
        System.out.println("sub : " + sub);
        copy.retainAll(sub); // 取交集
        System.out.println("retained list : " + copy);
        copy = new ArrayList<>(petties); // fresh copy
        copy.remove(2);
        System.out.println("remove by index : " + copy);
        copy.removeAll(sub);
        System.out.println("copy.removeAll(sub) : " + copy);
        copy.set(1,new Dog());
        System.out.println("replace one element : copy.set(1,new Dog()) : " + copy);
        copy.addAll(0,sub);
        System.out.println("insert into copy.addAll(0,sub) : " + copy);
        System.out.println("isEmpty ? " + petties.isEmpty());
        petties.clear();
        System.out.println("remove all elements pets.clear() " + petties.isEmpty());
        petties.addAll(copy);
        System.out.println(petties);
        Object [] objects = petties.toArray();
        System.out.println(objects[1]);
        // 如果数组参数太小不足以保存列表中的所有元素， toArray() 创建一个合适大小的新数组
        Petty[] pa = copy.toArray(new Petty[0]);
        System.out.println(pa[1]);
    }
}

abstract class Petty {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    abstract void call();
}

class Dog extends Petty {
    @Override
    void call() {
        System.out.println("wong");
    }
}

class Cat extends Petty {
    @Override
    void call() {
        System.out.println("mew");
    }
}

class Bird extends Petty {
    @Override
    void call() {
        System.out.println("Jiu");
    }
}