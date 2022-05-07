package com.angers.project.onjava8.generics.coffee;

/**
 * @author : liuanglin
 * @date : 2022/5/6 08:57
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter ++ ;

    @Override
    public String toString() {
        return "Coffee{" + getClass().getSimpleName() +
                " id=" + id +
                '}';
    }
}
