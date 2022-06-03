package com.angers.project.onjava8.compare;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/6/3 16:52
 * @description : 各种不同 Set 支持的元素类型
 */
class SetType {
    protected int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType &&
                Objects.equals(i,((SetType) obj).i);
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return Integer.compare(i,o.i);
    }
}
public class TypesForSets {
    static <T> void fill(Set<T> set, Function<Integer,T> type){
        IntStream.range(5,10).mapToObj(type::apply).forEach(set::add);
        IntStream.range(0,5).mapToObj(type::apply).forEach(set::add);
    }

    static <T> void test(Set<T> set,Function<Integer,T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<>(),HashType::new);
        test(new LinkedHashSet<>(),HashType::new);
        test(new TreeSet<>(),TreeType::new);
        test(new HashSet<>(),SetType::new);
        test(new HashSet<>(),TreeType::new);
        test(new LinkedHashSet<>(),SetType::new);
        test(new LinkedHashSet<>(),TreeType::new);
        try {
            /*
            TreeSet 中的元素必须是 Comparable 对象
            并且定义了 equals() 方法
             */
            test(new TreeSet<>(),SetType::new);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(),HashType::new);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        /* output :
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
        [5, 6, 7, 8, 9, 0, 1, 2, 3, 4]
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        [5, 0, 4, 7, 8, 0, 1, 2, 9, 7, 3, 5, 4, 8, 7, 6, 6, 2, 0, 8, 4, 9, 5, 2, 6, 1, 1, 3, 3, 9]
        [6, 2, 7, 2, 3, 3, 0, 2, 5, 5, 6, 7, 8, 9, 4, 8, 6, 7, 4, 8, 9, 3, 4, 5, 1, 9, 0, 0, 1, 1]
        [5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4]
        [5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4]
        com.angers.project.onjava8.compare.SetType cannot be cast to java.lang.Comparable
        com.angers.project.onjava8.compare.HashType cannot be cast to java.lang.Comparable
         */
    }
}

