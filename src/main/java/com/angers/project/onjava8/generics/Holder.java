package com.angers.project.onjava8.generics;


import java.util.Objects;

/**
 * @author : liuanglin
 * @date : 2022/5/9 15:28
 */
public class Holder <T>{
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder &&
                Objects.equals(value,((Holder)obj).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple apple1 = apple.getValue();
        apple.setValue(apple1);
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.getValue();
        apple1 = (Apple) fruit.getValue();
        try {
            Orange o = (Orange) fruit.getValue();
        }catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(fruit.equals(apple1));
    }
}
