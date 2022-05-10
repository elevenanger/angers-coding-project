package com.angers.project.onjava8.generics;

import java.lang.reflect.Array;

/**
 * @author : liuanglin
 * @date : 2022/5/9 11:00
 * @description :
 */
public class GenericArrayWithTypeToken <T>{
    private T[] array;
    @SuppressWarnings("unchecked")
    GenericArrayWithTypeToken(Class<T> type,int size){
        /*
        传入类型信息，通过类型构造数组实例
        在运行时获取到的类型信息为实际的类型
         */
        array = (T[]) Array.newInstance(type,size);
    }
    public void put(int index,T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }
    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> ints = new GenericArrayWithTypeToken<>(Integer.class,10);
        Integer[] integers = ints.rep();
        System.out.println(integers.getClass().getSimpleName());
    }
}
