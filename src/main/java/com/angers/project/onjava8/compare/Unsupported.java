package com.angers.project.onjava8.compare;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/3 16:09
 * @description : Java 各类集合不支持的
 */
public class Unsupported {
    /**
     * 执行检查程序
     * 如果出现异常输出异常信息
     * @param desc 描述
     * @param test 测试案例
     */
    static void check(String desc,Runnable test){
        try {
            test.run();
        }catch (Exception e){
            System.out.println(desc + " e = " + e);
        }
    }

    /**
     * 测试各类集合对于 Collection 接口中定义的方法的实现
     * @param msg 描述信息
     * @param list 集合对象
     */
    static void test(String msg, List<String> list){
        CommonUtils.printDivide(msg);
        Collection<String> collection = list;
        Collection<String> subCollection = list.subList(1,8);
        Collection<String> collection2 = new ArrayList<>(subCollection);
        check("retainAll()",() -> collection.retainAll(collection2));
        check("removeAll()",() -> collection.retainAll(collection2));
        check("clear", collection::clear);
        check("add",() -> collection.add("X"));
        check("addAll()",() -> collection.addAll(collection2));
        check("remove",() -> collection.remove("C"));
        check("List.set" ,() -> list.set(0,"X"));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N".split(" "));
        /*
        将 list 作为构造函数的参数
        创建一个常规的可以重新设置底层数据结构大小的集合
        以支持 Collection 中可以修改集合大小的方法
         */
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()",list);
        /*
        unmodifiableList() 是 Collections 类中的代理方法
        产生一个不可变的集合
        调用任何可以对于集合进行修改的方法
        都会抛出 UnsupportedOperationException
         */
        test("unmodifiableList()", Collections.unmodifiableList(list));

        /*
        output :
        >>>Modifiable Copy<<<
        >>>Arrays.asList()<<<
        Arrays.asList() 基于 Array()
        数组长度是不可变的
        所以不支持会改变数组大小的方法
        retainAll() e = java.lang.UnsupportedOperationException
        removeAll() e = java.lang.UnsupportedOperationException
        clear e = java.lang.UnsupportedOperationException
        add e = java.lang.UnsupportedOperationException
        addAll() e = java.lang.UnsupportedOperationException
        remove e = java.lang.UnsupportedOperationException
        >>>unmodifiableList()<<<
        retainAll() e = java.lang.UnsupportedOperationException
        removeAll() e = java.lang.UnsupportedOperationException
        clear e = java.lang.UnsupportedOperationException
        add e = java.lang.UnsupportedOperationException
        addAll() e = java.lang.UnsupportedOperationException
        remove e = java.lang.UnsupportedOperationException
        List.set e = java.lang.UnsupportedOperationException
         */
    }
}
