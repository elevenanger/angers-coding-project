package com.angers.project.onjava8.generics.coffee;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:00
 * @description :泛型-咖啡族工厂方法
 */
public class CoffeeSupplier implements Supplier<Coffee>,Iterable<Coffee> {
    private Class<?> [] types = {
            Latte.class,
            Americano.class,
            Breve.class,
            Mocha.class,
            Cappuccino.class
    };
    private static Random random = new Random(93);
    private int size = 0;

    public CoffeeSupplier() {
    }

    public CoffeeSupplier(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee get() {
        try {
            return (Coffee) types[random.nextInt(types.length)]
                    .getConstructor().newInstance();
        }catch (InstantiationException |
                NoSuchMethodException|
                InvocationTargetException|
                IllegalAccessException exception){
            throw new RuntimeException(exception);
        }
    }
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count -- ;
            return CoffeeSupplier.this.get();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier())
                .limit(10)
                .forEach(System.out::println);
    }
}