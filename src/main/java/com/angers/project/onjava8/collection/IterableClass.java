package com.angers.project.onjava8.collection;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/4/19 18:11
 * @description : 集合-实现 Iterable 接口的类都可以使用 for-in 语法
 */
public class IterableClass implements Iterable<String>{
    protected String [] strings = ("we are the world we are the children").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return  index < strings.length;
            }
            @Override
            public String next() {
                return strings[index++];
            }
        };

    }

    /**
     * 测试一个对象是否是可迭代的对象
     * @param iterable 可迭代对象
     * @param <T> 任意类型
     */
    static <T> void test(Iterable<T> iterable){
        for (T t: iterable){
            System.out.printf(t+ " ");
        }
    }
    public static void main(String[] args) {
        for (String s: new IterableClass()){
            System.out.print(s+ " ");
        }

        System.getenv()
                .forEach((key, value)
                        -> System.out.println(key + " : " + value));

        test(Arrays.asList(1,2,3));
        String [] chars = {"A","B","C"};
        /*
        test(chars); Array 不是 Iterable 对象
        可以使用 for in 语句是因为自动装箱机制
         */
        for (String s: chars) {
            System.out.printf(s+ " ");
        }
        test(Arrays.asList(chars));
    }
}
