package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/7 09:41
 * @description : 泛型，使用工厂方法约束泛型
 */
public class FactoryConstraint  {
    public static void main(String[] args) {
        // IntegerFactory 本身就是一个实现了 Supplier 接口的工厂类
        System.out.println(new Foo2<>(new IntegerFactory()));
        // Widget.Factory() 也是一个工厂内部类
        System.out.println(new Foo2<>(new Widget.Factory()));
        // Fudge::new 满足 Supplier 函数的定义
        System.out.println(new Foo2<>(Fudge::new));
    }
}

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;
    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget {
    private int id;
    public Widget(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                '}';
    }
    public static class Factory implements Supplier<Widget> {
        private int i = 0;

        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 1;
    private int n = count ++;
    @Override
    public String toString() {
        return "Fudge{" +
                "n=" + n +
                '}';
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();
    Foo2(Supplier<T> factory){
        Suppliers.fill(x,factory,5);
    }
    @Override
    public String toString() {
        return "Foo2{" +
                "x=" + x.toString() +
                '}';
    }
}