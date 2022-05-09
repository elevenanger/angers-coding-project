package com.angers.project.onjava8.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/7 08:47
 * @description :
 */
public class ListMaker<T> {
    List<T> create(){ return new ArrayList<>(); }

    public static void main(String[] args) {
        // 在初始化泛型类型对象时指定了泛型类型参数，在编译擦除泛型阶段会直接指定其参数类型
        ListMaker<String> maker = new ListMaker<>();
        List<String> strings = maker.create();
        strings.add("and");
        System.out.println(strings);
    }
}
