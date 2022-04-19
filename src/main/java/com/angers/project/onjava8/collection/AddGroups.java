package com.angers.project.onjava8.collection;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/18 15:30
 * @description : 集合-添加一组对象
 */
public class AddGroups {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer [] more = {6,7,8,9,10};
        integers.addAll(Arrays.asList(more));
        /*
        使用 Collections 工具类能够显著提升性能
        但是不能用它来构造集合对象
         */
        Collections.addAll(integers,11,12,13);
        Collections.addAll(integers,more);
        // 使用数组创建一个列表
        List<Integer> list = Arrays.asList(21,22,23);
        list.set(1,93); // 修改列表中的元素
        integers.forEach(v -> System.out.print(v+ " "));
        System.out.println();
        list.forEach(v -> System.out.print(v+ " "));
    }
}
