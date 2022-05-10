package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 09:59
 * @description : 泛型-泛型数组
 */
public class ArrayOfGenericReference {
    static  Generic<Integer> [] ints ;

    public static void main(String[] args) {
        try {
            ints = (Generic<Integer>[]) new Object[10];
            System.out.println(ints.getClass().getSimpleName());
        }catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
        ints = (Generic<Integer>[]) new Object[10];
        System.out.println(ints.getClass().getSimpleName());
        ints[0] = new Generic<>();
    }
}

class Generic<T> {}