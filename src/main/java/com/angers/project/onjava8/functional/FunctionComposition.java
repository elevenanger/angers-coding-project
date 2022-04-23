package com.angers.project.onjava8.functional;

import java.util.function.Function;

/**
 * @author : liuanglin
 * @date : 2022/4/22 10:03
 * @description : 函数-组合函数
 */
public class FunctionComposition {
    static Function<String,String> f1 = s -> {
        System.out.println("f1: " +s);
        return s.replace('a','_');
    };
    static Function<String,String> f2 = s -> {
        System.out.println("f2: " + s);
        return s.substring(2);
    };
    static Function<String,String> f3 = s ->{
        System.out.println("f3:" + s);
        return s.toLowerCase();
    };
    /*
    组合多个 Function
    调用顺序 f3 - f1 - f2
     */
    static Function<String,String> f4 = f1.andThen(f2).compose(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("WE ARE THE WORLD"));
    }
}
