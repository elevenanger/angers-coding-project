package com.angers.project.onjava8.housekeeping;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/9 10:51
 * @description : 使用数组语法创建数组参数列表
 */
public class NewVarArgs {

    /**
     * 打印变量参数列表
     * 使用变量参数列表无需显式地声明数组语法
     * 编译器会根据传入参数自动适配，最终生成一个数组
     * @param args 变量参数列表
     */
    static void printArray(Object ... args){
        Arrays.stream(args)
                .map(CommonUtils::concatenateSpace)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(93,(float)93.32,11.2F,'c',"time",6.5d,23123123123123132L);
        printArray(new A(),new A());
        printArray((Object []) new Integer [] {1,2,3,4,5});
        printArray(); // 可以为空，当你有可选的参数时，这个特性非常有帮助

        /*
        output
        93 93.32 11.2 c ,time 6.5 23123123123123132
        thi is A! thi is A!
        1 2 3 4 5
         */
    }
}

class A {
    @Override
    public String toString() {
        return "thi is A!";
    }
}