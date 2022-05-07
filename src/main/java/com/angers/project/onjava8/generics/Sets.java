package com.angers.project.onjava8.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : liuanglin
 * @date : 2022/5/6 11:13
 * @description :集合工具类
 */
public class Sets {
    /*
    合集
     */
    public static <T>Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    /*
    交集
     */
    public static <T>Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    /*
    a - a b 交集
     */
    public static <T>Set<T> difference(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
    /*
    a b 合集 - a b交集
     */
    public static <T>Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a, b),intersection(a,b));
    }

}
