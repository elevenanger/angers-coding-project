package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.common.CommonUtils;
import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/19 09:30
 * @description : 集合-使用迭代统一对各种集合类型的访问
 */
public class CrossCollectionIteration {

    /**
     * 通过集合的迭代器对集合进行遍历
     * @param it 集合迭代器
     */
    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id() + " : " + p + " ");
        }
        System.out.println();
    }

    /**
     * 集合遍历-直接遍历集合
     * @param ip Iterable 集合对象
     */
    public static void display(Iterable<Pet> ip){
        for (Pet p : ip) {
            System.out.print(p.id() + " : " + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(10);
        LinkedList<Pet> petLinkedList = new LinkedList<>(pets);
        HashSet<Pet> petHashSet = new HashSet<>(pets);
        TreeSet<Pet> petTreeSet = new TreeSet<>(pets);
        display(pets.iterator());
        display(petLinkedList.iterator());
        display(petHashSet.iterator());
        display(petTreeSet.iterator());
        CommonUtils.printDivideLine("iterable");
        display(pets);
        display(petLinkedList);
        display(petHashSet);
        display(petTreeSet);
    }
}
