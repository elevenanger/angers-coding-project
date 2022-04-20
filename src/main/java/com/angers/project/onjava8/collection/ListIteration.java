package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.common.CommonUtils;
import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.List;
import java.util.ListIterator;

/**
 * @author : liuanglin
 * @date : 2022/4/19 09:49
 * @description : 集合-使用 ListIterator 遍历 List
 * ListIterator 用于对 List 进行遍历
 * ListIterator 可以前后双向进行移动
 * 可以从头开始遍历
 * 也可以从指定位置开始 listIterator(n)
 * 使用 set() 方法替换最后一个访问的元素
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(10);
        ListIterator<Pet> petListIterator  = pets.listIterator();
        while (petListIterator.hasNext()){
            System.out.print(petListIterator.next() + "," + // 顺序迭代
                    petListIterator.nextIndex()+ "," + // next 元素索引
                    petListIterator.previousIndex()+ ":"); // previous 元素索引
        }
        CommonUtils.printDivideLine("previous");
        while (petListIterator.hasPrevious()) {
            System.out.print(petListIterator.previous() + "," + // 倒序迭代
                    petListIterator.nextIndex()+ "," +
                    petListIterator.previousIndex()+ ":");
        }
        petListIterator = pets.listIterator(3);
        while (petListIterator.hasNext()){
            petListIterator.next();
            // 使用 set() 最后一个访问的元素
            petListIterator.set(new PetCreator().get());
        }
        System.out.println(pets);
    }
}
