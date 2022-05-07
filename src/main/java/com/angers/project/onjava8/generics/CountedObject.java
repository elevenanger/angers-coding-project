package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/6 10:04
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter ++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject{" +
                "id=" + id +
                '}';
    }
}
