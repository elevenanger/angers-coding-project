package com.angers.project.onjava8.collection;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/19 18:53
 * @description : 添加多个适配器方法
 */
public class MultiIterableClass extends IterableClass{
    public Iterable<String> reverse(){
        return () -> new Iterator<String>() {
            int current = strings.length-1;
            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public String next() {
                return strings[current--];
            }
        };
    }

    public Iterable<String> randomized(){
        return () -> {
            List<String> shuffled = new ArrayList<>(Arrays
                    .asList(strings));
            Collections.shuffle(shuffled);
            return shuffled.iterator();
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mc = new MultiIterableClass();
        mc.reverse().forEach(v -> System.out.print(v + " "));
        System.out.println();
        mc.randomized().forEach(v -> System.out.print(v+ " "));
    }
}
