package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/4 18:40
 * @description : 使用 Collections 工具类创建只读集合
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c =
                Collections.unmodifiableCollection(
                        new ArrayList<>(data));
        System.out.println(c);
        List<String> a =
                Collections.unmodifiableList(
                new ArrayList<>(data));
        System.out.println(a);
        ListIterator<String> listIterator = a.listIterator();
        System.out.println(listIterator.next());
        Set<String> set =
                Collections.unmodifiableSet(
                        new HashSet<>(data));
        System.out.println(set);
        Set<String> set2 =
                Collections.unmodifiableSet(
                        new TreeSet<>(data));
        System.out.println(set2);
        Map<String,String> map =
                Collections.unmodifiableMap(
                        new HashMap<>(Countries.capitals(6)));
        System.out.println(map);
        Map<String,String> map2 =
                Collections.unmodifiableMap(
                        new TreeMap<>(Countries.capitals(6)));
        System.out.println(map2);
    }
}
