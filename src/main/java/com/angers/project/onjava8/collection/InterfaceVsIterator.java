package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/19 16:26
 * @description : 集合-遍历方式比较
 * 分别使用迭代和 for in 遍历元素
 * 使用 Collection 会更优一点
 * 因为 Collection 是可迭代的，抽象程度更高
 * 对于服务调用方来说更简单，不需要额外实现或者创建迭代器
 */
public class InterfaceVsIterator {
    /**
     * 传入迭代器进行遍历
     * @param it Pet 迭代器
     */
    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id() + " : " + p + " ");
        }
        System.out.println();
    }

    /**
     * 传入集合进行遍历
     * @param pets Pet 集合
     */
    public static void display(Collection<Pet> pets){
        for (Pet p: pets) {
            System.out.print(p.id() + " : " + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(10);
        Set<Pet> petSet = new HashSet<>(pets);
        Map<String,Pet> petMap = new LinkedHashMap<>();
        String [] names = {"kevin","carl","hale","kobe","charles","perl"};
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i],pets.get(i));
        }
        display(pets);
        display(pets.iterator());
        display(petSet);
        display(petSet.iterator());
        System.out.println(petMap);
        display(petMap.values());
        display(petMap.values().iterator());
    }
}
