package com.angers.project.onjava8.compare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/6/4 18:52
 * @description :
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Iterator<String> iterator = collection.iterator();
        collection.add("An obj");
        try {
            String s = iterator.next();
        }catch (ConcurrentModificationException e){
            System.out.println(e);
        }
    }
}
