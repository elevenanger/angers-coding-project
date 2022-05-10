package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 10:52
 * @description :
 */
public class GenericArray2<T> {
    private Object [] array;
    GenericArray2(int size){
        array = new Object[size];
    }
    public void put(int index,T item){
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T) array[index];
    }
    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> ints = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            ints.put(i,i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(ints.get(i));
        }
        try {
            Integer [] ia = ints.rep();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
