package com.angers.project.onjava8.functional;

import java.util.function.Function;

/**
 * @author : liuanglin
 * @date : 2022/4/21 10:39
 * @description : 函数-高阶函数-用消费的函数产生新的函数
 */
public class TransformFunction {
    static Function<I,O> transform(Function<I,O> in){
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I,O> function = TransformFunction.transform(i -> {
            System.out.println(i);
            return new O();
        });
        O o = function.apply(new I());
        System.out.println(o);
    }
}

class I {
    @Override
    public String toString() {
        return "I";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}