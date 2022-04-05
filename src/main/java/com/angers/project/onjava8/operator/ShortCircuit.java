package com.angers.project.onjava8.operator;

/**
 * @author : liuanglin
 * @date : 2022/4/4 16:20
 * @description : 逻辑表达式"短路"原理
 * 当可以通过完整的表达式当中的部分表达式判断整个表达式的真假
 * 将在这部分表达式执行完毕之后直接返回结果，而不会继续执行之后的判断逻辑
 * 这种机制可以提升程序执行的性能
 */
public class ShortCircuit {

    static boolean test1(int val){
        System.out.println("test1(" + val +")");
        System.out.println("result: "+ (val < 1));
        return val < 1;
    }

    static boolean test2(int val){
        System.out.println("test2(" + val +")");
        System.out.println("result: "+ (val < 2));
        return val < 2;
    }

    static boolean test3(int val){
        System.out.println("test1(" + val +")");
        System.out.println("result: "+ (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        // test(2) = false ,整个表达式结束，不再继续执行 test3
        boolean b = test1(0) && test2(2) && test3(2);
        System.out.println("expression result : " + b);
    }

}
