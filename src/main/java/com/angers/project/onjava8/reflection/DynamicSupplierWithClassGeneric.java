package com.angers.project.onjava8.reflection;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/2 09:47
 * @description : 反射-通过泛型机制使用 Class 对象动态生成对象
 */
class ID {
    private static long counter;
    private final long id = counter ++ ;
    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }
    public ID() {}
}
public class DynamicSupplierWithClassGeneric<T> implements Supplier<T> {
    private Class<T> type;

    /**
     * 传入类型，进行 Supplier 初始化
     * @param type 对象类型
     */
    public DynamicSupplierWithClassGeneric(Class<T> type) {
        this.type = type;
    }

    /**
     * 根据 Supplier 实例中的类型
     * 使用反射调用其构造函数
     * 完成类型对象的构造
     * @return Supplier 初始化类型对象
     */
    @Override
    public T get() {
        try {
            return type.getConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplierWithClassGeneric<>(ID.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
