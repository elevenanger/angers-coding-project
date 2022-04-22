package com.angers.project.onjava8.functional;

import java.util.function.BiConsumer;

/**
 * @author : liuanglin
 * @date : 2022/4/21 09:07
 * @description : 函数-方法转换
 */
public class MethodConversion {
    static void accept(In1 in1,In2 in2){
        System.out.println("accept()");
    }
    static void someOtherName(In1 in1,In2 in2){
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        // 方法签名与函数接口方法签名匹配，即可传递方法代码
        BiConsumer<In1,In2> biConsumer;
        biConsumer = MethodConversion::accept;
        biConsumer.accept(new In1(),new In2());
        biConsumer = MethodConversion::someOtherName;
        biConsumer.accept(new In1(),new In2());
    }
}

class In1 {}

class In2{}
