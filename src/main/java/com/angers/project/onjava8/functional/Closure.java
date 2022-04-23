package com.angers.project.onjava8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/4/22 08:34
 * @description : 函数-闭包
 */
public class Closure {
    private int i ;

    /**
     * 考虑一个更复杂的 lambda，它使用函数范围之外的变量
     * 当返回那个函数时会发生什么
     * 也就是说，当调用函数时，它为那些“外部”变量引用了什么
     * @param x 入参
     * @return IntSupplier 接口函数
     */
    IntSupplier makeFun(int x){
        // 接收方法参数和对象实例域的函数
        return () -> x + ( ++ i) ;
    }

    /**
     * 定义局部变量进行运算
     * 使用 lambda 表达式关闭变量
     * 局部变量和方法参数初始化从未发生变化具备有效 final 属性
     * 不需要显示声明 final
     * @param x 方法参数
     * @return IntSupplier 接口函数
     */
    IntSupplier makeFun1(int x){
        // j 定义为局部变量，和 x 都在函数内关闭
        int j = 0;
        /*
        j++; x++;
        尝试在 lambda 表达式中改变局部变量的值会报错
        lambda 表达式中的变量必须是有效 final 属性
         */
        return () -> x + j ;
    }

    /**
     * 显示声明局部变量和参数为 final
     * @param x 入参
     * @return IntSupplier 接口函数
     */
    IntSupplier makeFun2(final int x){
        final int j = 0;
        return () -> x + j;
    }

    IntSupplier makeFun3(int x){
        int j = 0;
        x ++;
        j ++;
        int xFinal = x;
        int jFinal = j;
        // 确保最终在 lambda 表达式的变量为有效 final 即可
        return () -> xFinal + jFinal;
    }

    Supplier<List<Integer>> makeFun(){
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        Integer j = 0;
        j ++ ;
        integers.add(j);
        j ++;
        integers.add(j);
        // integers 对象引用在定义后未发生变化，所以也是有效final
        return () -> integers;
    }

    /**
     * 使用匿名内部类实现闭包
     * 只要匿名有内部类，就是闭包
     * 因为其参数都是有效 final
     * @param x 入参
     * @return IntSupplier
     */
    IntSupplier makeInAnonymous(int x){
        int j = 0;
        return new IntSupplier() { // 匿名内部类
            @Override
            public int getAsInt() {
                return x + j;
            }
        };
    }

    public static void main(String[] args) {
        /*
        i 作为 Closure 对象实例域，如果多次调用 makeFun 方法产生接口对象
        所有产生的接口对象都共享同一个 Closure 对象
        以及对象实例域
         */
        Closure closure1 = new Closure();
        IntSupplier s1 = closure1.makeFun(11);
        IntSupplier s2 = closure1.makeFun(12);
        IntSupplier s3 = closure1.makeFun(13);
        System.out.println(s1.getAsInt());
        System.out.println(s2.getAsInt());
        System.out.println(s3.getAsInt());

        /*
        makeFun1 方法关闭了 x 和 i
         */
        IntSupplier s4 = closure1.makeFun1(11);
        IntSupplier s5 = closure1.makeFun1(12);
        IntSupplier s6 = closure1.makeFun1(13);
        System.out.println(s4.getAsInt());
        System.out.println(s5.getAsInt());
        System.out.println(s6.getAsInt());

        /*
        每次调用 closure1.makeFun().get() 都会产生并返回一个新的 List<Integer> 对象
        多次调用产生的对象之间是不共享的（integers1，integers2）独立的对象
        所以可以说
        每个产生的闭包都有其独立的 ArrayList 对象并且互不干涉
         */
        List<Integer> integers1 = closure1.makeFun().get();
        List<Integer> integers2 = closure1.makeFun().get();
        System.out.println(integers1);
        System.out.println(integers2);
        integers1.add(10);
        integers2.add(11);
        System.out.println(integers1);
        System.out.println(integers2);
    }
}