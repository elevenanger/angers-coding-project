package com.angers.project.onjava8.generics;

import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/7 09:33
 * @description :
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Somebody> cs = new ClassAsFactory<>(Somebody.class);
        cs.get();
        /*
        Integer 没有无参构造函数，使用该方法会报错
        因为这个错误不是在编译是发现
         */
        ClassAsFactory<Integer> ci = new ClassAsFactory<>(Integer.class);
        ci.get();
    }
}

class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;

    public ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }

    @Override
    public T get() {
        try {
            // 调用类的无参构造函数创建类型对象
            return kind.getConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Somebody{
    public Somebody() {
        System.out.println("somebody");
    }
}
