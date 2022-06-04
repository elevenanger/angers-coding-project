package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/4 18:31
 * @description : 使用 Collections 工具类对 list 进行搜索和排序
 */
public class ListSortSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        System.out.println(list);
        Collections.shuffle(list,new Random(93));
        System.out.println("shuffled : " + list);
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("trimmed : " + list);
        Collections.sort(list);
        System.out.println("sorted : " + list);
        String key = list.get(7);
        int index = Collections.binarySearch(list,key);
        System.out.println(
                "Location of " + key + " is " + index +
                        " , list.get(" + index + ") = " +
                        list.get(index));
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println("CASE_INSENSITIVE_ORDER sort : " + list);
        key = list.get(7);
        index = Collections.binarySearch(list,key,String.CASE_INSENSITIVE_ORDER);
        System.out.println(
                "Location of " + key + " is " + index +
                        " , list.get(" + index + ") = " +
                        list.get(index));
    }
}
