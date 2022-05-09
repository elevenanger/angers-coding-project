package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/7 08:55
 */
public class FilledList <T> extends ArrayList<T> {
    FilledList(Supplier<T> gen,int size){
        Suppliers.fill(this,gen,size);
    }
    public FilledList(T t,int size){
        for (int i = 0; i < size; i++) {
            /*
            编译器不知道 add 方法中 T 的类型
            但是任然可以确保，在编译阶段往 FilledList 中传入的参数类型 T
            即使擦除去掉了泛型方法或者类中的实际类型信息
            编译器任然可以确保参数类型在方法或者类中使用的内在的一致性
            因为擦除去掉了方法体中的类型信息
            在运行时最重要的边界：对象进入和离开方法的点
            这些节点是编译器在编译时执行类型检查以及插入转换代码的位置
             */
            this.add(t);
        }
    }

    public static void main(String[] args) {
        List<String> list = new FilledList<>("Hello",4);
        System.out.println(list);
        List<Integer> integers = new FilledList<>(() -> 93,10);
        System.out.println(integers);
    }
}
