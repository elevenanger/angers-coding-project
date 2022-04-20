package com.angers.project.onjava8.collection;

import com.angers.project.onjava8.reflection.pets.*;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/4/19 16:56
 * @description : 集合-继承 AbstractCollection
 */
public class CollectionsSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new PetCreator().array(8);
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }
            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionsSequence c = new CollectionsSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
