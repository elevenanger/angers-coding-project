package com.angers.project.onjava8.functional;

import java.util.function.Function;

/**
 * @author : liuanglin
 * @date : 2022/4/21 10:27
 * @description : 函数-高阶函数-产生函数
 */
public class ProduceFunction {
    /**
     * 高阶函数-产生函数的函数
     * @return 函数接口对象
     */
    static FuncSS produce(){
        return String::toLowerCase;
    }

    public static void main(String[] args) {
        FuncSS func = ProduceFunction.produce();
        System.out.println(func.apply("HELLO"));
    }
}
/*
使用继承，创建一个 Function<String,String>  接口
 */
interface FuncSS extends Function<String,String> {}
