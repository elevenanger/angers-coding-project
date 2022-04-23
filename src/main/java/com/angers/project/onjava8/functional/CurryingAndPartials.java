package com.angers.project.onjava8.functional;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * @author : liuanglin
 * @date : 2022/4/22 10:48
 * @description : 函数-柯里化函数
 * 把接受多个参数的函数转变成接收单一参数的函数序列，序列中的每一个函数都只接收一个参数
 */
public class CurryingAndPartials {

    /**
     *
     * @return x -> y -> x + y; 接收两个参数，分别用两个 Function 去处理
     */
    static Function<String,Function<String,String>> curryingFunction(){
        System.out.println("curryingFunction():");
        return x -> y -> x + y;
    }

    static Function<String ,
            Function<String,
                    Function<String,String>>> curryingThreeFunction(){
        System.out.println("curryingThreeFunction()");
        return x -> y -> z -> x + y + z;
    }

    static IntFunction<IntUnaryOperator> curryingIntAdd(){
        System.out.println("curryingIntAdd()");
        return a -> b -> a + b;
    }
    public static void main(String[] args) {
        System.out.println(curryingFunction()
                .apply("first ")
                .apply("second"));
        System.out.println(curryingThreeFunction()
                .apply("first ")
                .apply("second ")
                .apply("third"));
        System.out.println(curryingIntAdd()
                .apply(10)
                .applyAsInt(11));
    }
}
