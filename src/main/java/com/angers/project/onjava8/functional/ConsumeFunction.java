package com.angers.project.onjava8.functional;

import java.util.function.Function;

/**
 * @author : liuanglin
 * @date : 2022/4/21 10:32
 * @description : 函数-高阶函数-消费函数
 */
public class ConsumeFunction {
    static Two consume(Function<One,Two> function){
        return function.apply(new One());
    }

    public static void main(String[] args) {
        Function<One,Two> function = one -> new Two();
        Two two = ConsumeFunction.consume(function);
        System.out.println(two);
    }
}

class One {}
class Two {}
