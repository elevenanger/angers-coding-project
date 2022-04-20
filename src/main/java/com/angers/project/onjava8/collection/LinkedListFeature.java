package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.Hamster;
import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;
import com.angers.project.onjava8.reflection.pets.Rat;

import java.util.LinkedList;

/**
 * @author : liuanglin
 * @date : 2022/4/19 10:09
 * @description : 集合-LinkedList 特性
 * LinkedList 在列表中插入和删除元素比 ArrayList 更高效
 * 但是随机读的性能较差
 */
public class LinkedListFeature {
    public static void main(String[] args) {
        LinkedList<Pet> pets =
                new LinkedList<>(new PetCreator().list(5));
        System.out.println(pets);
        // 获取集合中的第一个元素
        System.out.println("pets.getFirst() "+ pets.getFirst());
        System.out.println("pets.element() " + pets.element());
        System.out.println("pets.peek() " + pets.peek());
        // 删除集合中第一个元素
        System.out.println("pets.remove() "+ pets.remove());
        System.out.println("pets.removeFirst() " + pets.removeFirst());
        System.out.println("pets.poll()" + pets.poll());
        System.out.println(pets);
        // 往集合头部添加元素
        pets.addFirst(new Rat());
        System.out.println(pets);
        // 往集合尾部添加元素
        pets.offer(new PetCreator().get());
        System.out.println(pets);
        pets.add(new PetCreator().get());
        System.out.println(pets);
        pets.addLast(new Hamster());
        System.out.println(pets);
        System.out.println("pets.removeLast() " + pets.removeLast());
    }
}
