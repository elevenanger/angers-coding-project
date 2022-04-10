package com.angers.project.onjava8.housekeeping;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/9 09:53
 * @description : 将数组作为参数传递给 main 方法
 */
public class DynamicArray {
    public static void main(String[] args) {
    String [] strings = {"words","class","function"};
        Other.main(strings);
    }
}

class Other {
    public static void main(String[] args) {
        Arrays.stream(args)
                .map(v -> v+=" ")
                .forEach(System.out::print);
    }
}
