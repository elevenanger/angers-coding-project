package com.angers.project.onjava8.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/9 09:55
 * @description :
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item){
        add(item);
    }
    public T get(int index){
        return array.get(index);
    }
}
