package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 10:31
 * @description :
 */
public class GenericArray <T>{
    private T[] array;

    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }
    public void put(int index ,T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> ints = new GenericArray<>(10);
        try {
            // 类型信息在运行时被擦除，得到的是一个 Object[] 数组
            Integer[] ia = ints.rep();
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
        Object [] oa = ints.rep();
    }
}
