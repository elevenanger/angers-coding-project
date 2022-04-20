package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.Pet;
import com.angers.project.onjava8.reflection.pets.PetCreator;

import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/4/19 18:06
 * @description :
 */

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}
public class NonCollectionSequence extends PetSequence{

    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return  index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence sequence = new NonCollectionSequence();
        InterfaceVsIterator.display(sequence.iterator());
    }
}
