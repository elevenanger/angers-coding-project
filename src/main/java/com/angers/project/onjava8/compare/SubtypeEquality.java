package com.angers.project.onjava8.compare;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author : liuanglin
 * @date : 2022/6/2 09:34
 * @description : 子类对象比较
 */
enum Size {SMALL,MEDIUM,LARGE}
class Animal {
    private static int counter = 0;
    private final int id = counter ++ ;
    private final String name;
    private final Size size;

    public Animal(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Animal &&
                Objects.equals(name,((Animal) obj).name) &&
                Objects.equals(size,((Animal) obj).size) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,size);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size + '\'' +
                ", hashCode=" + hashCode() +
                '}';
    }
}

class Dog extends Animal {
    public Dog(String name, Size size) {
        super(name, size);
    }
}

class Pig extends Animal {
    public Pig(String name, Size size) {
        super(name, size);
    }
}

class Dog2 extends Animal {
    public Dog2(String name, Size size) {
        super(name, size);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Dog2 &&
                super.equals(obj);
    }
}

class Pig2 extends Animal {
    public Pig2(String name, Size size) {
        super(name, size);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pig2 &&
                super.equals(obj);
    }
}

public class SubtypeEquality {
    public static void main(String[] args) {
        Set<Animal> animals = new HashSet<>();
        animals.add(new Dog("Huang",Size.LARGE));
        animals.add(new Pig("Huang",Size.LARGE));
        /*
        Animal.equals() 方法只比较 name ,size
        Animal.hashCode() 方法也只对 name,size 进行 hash
        不同子类 name size 属性值相等就会导致 equals() 比较下是相等的对象
         */
        animals.forEach(System.out::println);
        animals.clear();
        /*
        子类重写 equals() 方法
        instanceof 比较是否为子类类型
        虽然 hashcode 是相等的
        但是 equals() 比较为 false
        两个对象都会被添加至 HashSet 中
         */
        animals.add(new Dog2("Huang",Size.LARGE));
        animals.add(new Pig2("Huang",Size.LARGE));
        animals.forEach(System.out::println);
    }
}
