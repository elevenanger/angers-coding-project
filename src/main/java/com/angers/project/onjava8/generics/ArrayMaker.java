package com.angers.project.onjava8.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/7 08:42
 * @description :
 */
public class ArrayMaker <T>{
    /*
    Class<T> 只是存储为一个 Class，没有参数
    所以想要以此创建一个新的实例
    是没有类型参数的
     */
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size){
        return (T[]) Array.newInstance(kind,size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> maker = new ArrayMaker<>(String.class);
        String [] strings = maker.create(10);
        System.out.println(Arrays.toString(strings));
    }
}
