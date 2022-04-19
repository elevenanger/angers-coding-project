package com.angers.project.onjava8.collection;

import java.util.ArrayList;

/**
 * @author : liuanglin
 * @date : 2022/4/18 12:13
 * @description : 集合-向上转型
 */
public class GenericAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new Fuji());
        apples.add(new Gala());
        apples.forEach(System.out::println);
        /* output:
        Apple{id=0}
        Fuji
        Gala
         */
    }
}

class Fuji extends Apple {
    @Override
    public String toString() {
        return "Fuji";
    }
}

class Gala extends Apple {
    @Override
    public String toString() {
        return "Gala";
    }
}
