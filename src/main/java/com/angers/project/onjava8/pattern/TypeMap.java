package com.angers.project.onjava8.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/27 14:22
 * @description :
 */
public class TypeMap<T> {
    public final Map<Class, List<T>> map = new HashMap<>();
    public void add(T o){
        Class type = o.getClass();
        map.computeIfAbsent(type,
                k -> new ArrayList<>()).add(o);
    }
    public Stream<List<T>> values(){
        return map.values().stream();
    }
}
