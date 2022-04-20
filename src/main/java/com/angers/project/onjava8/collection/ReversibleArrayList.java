package com.angers.project.onjava8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/4/19 18:35
 * @description :
 */
public class ReversibleArrayList <T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed(){
        return () -> new Iterator<T>() {
            private int current = size()-1;
            @Override
            public boolean hasNext() {
                return current > -1;
            }
            @Override
            public T next() {
                return get(current--);
            }
        };
    }

    public static void main(String[] args) {
        ReversibleArrayList<String> ra1 = new ReversibleArrayList<>(Arrays.asList("you are not alone".split(" ")));
        for (String s:ra1) {
            System.out.print(s+" ");
        }
        System.out.println();
        for (String s: ra1.reversed()) {
            System.out.print(s+" ");
        }
    }
}
