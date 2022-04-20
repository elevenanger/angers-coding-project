package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.Iterator;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/4/19 09:17
 * @description : 集合-迭代
 */
public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(10);
        Iterator<Pet> petIterator = pets.iterator();
        while (petIterator.hasNext()){
            Pet pet =  petIterator.next();
            System.out.print(pet.id()+ " : " + pet + " ");
        }
        System.out.println();
        for (Pet pet : pets ){
            System.out.print(pet.id()+ " : " + pet + " ");
        }
        System.out.println();
        petIterator = pets.iterator();
        for (int i = 0; i < 6; i++) {
            petIterator.next();
            petIterator.remove();
        }
        System.out.println(pets);
    }
}