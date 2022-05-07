package com.angers.project.onjava8.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/6 09:45
 * @description :泛型-泛型与可变参数列表
 */
public class GenericVarargs {
    /**
     * 泛型与可变参数列表可以配合使用
     * @param args 类型参数列表
     * @return 列表
     * @param <T> 泛型返回值
     */
    @SafeVarargs
    public static <T>List<T> makeList(T ... args){
        return Arrays.stream(args)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = makeList("dadadasdfdaskjhsdkj".split(""));
        System.out.println(list);
    }
}
