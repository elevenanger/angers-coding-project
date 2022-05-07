package com.angers.project.onjava8.generics;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/6 12:07
 */
public class CollectionMethodDifferences {
    static Set<String> methodSet (Class<?> type){
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }
    static void interfaces(Class<?> type){
        System.out.println("interfaces in " + type.getClass().getSimpleName());
        System.out.println(Arrays.stream(type.getInterfaces())
                .map(Class::getName)
                .collect(Collectors.toList()));
    }
    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }
    static void diff(Class<?> superset,Class<?> subset){
        System.out.println(superset.getSimpleName() +
                " extends " + subset.getSimpleName() +
                " , adds : ");
        Set<String> comp = Sets.difference(methodSet(superset),methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection : " +
                methodSet(Collection.class));
        interfaces(Collection.class);
        diff(Set.class,Collection.class);
        diff(HashSet.class,Set.class);
    }
}
