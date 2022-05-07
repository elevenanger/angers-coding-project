package com.angers.project.onjava8.generics;

import java.util.HashSet;

/**
 * @author : liuanglin
 * @date : 2022/5/6 15:31
 */
public class ErasedTypeEquivalance {
    public static void main(String[] args) {
        Class c1 = new HashSet<Integer>().getClass();
        Class c2 = new HashSet<Long>().getClass();
        System.out.println(c2==c1);
    }
}
