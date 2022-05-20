package com.angers.project.onjava8.pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/19 11:09
 * @description : 设计模式-单例
 * 单例设计模式 ： 提供有且仅有一个对象实例
 */
final class IntegerSingleton implements Resource<Integer> {
    private static IntegerSingleton integerSingleton
            = new IntegerSingleton();
    private Integer i = Integer.valueOf(0);
    private IntegerSingleton(){
        System.out.println("IntegerSingleton()");
    }
    public static IntegerSingleton getInstance(){
        return integerSingleton;
    }

    @Override
    public Integer get() {
        return i;
    }

    @Override
    public void set(Integer integer) {
        i = integer;
    }
}

public class SingletonPattern {
    public static <T> void show(Resource<T> resource){
        T val = resource.get();
        System.out.println(val);
    }

    public static <T> void put(Resource<T> resource,T val){
        resource.set(val);
    }

    public static void main(String[] args) {
        System.out.println("Inside Main");
        Resource<Integer> integerResource1 = IntegerSingleton.getInstance();
        Resource<Integer> integerResource2 = IntegerSingleton.getInstance();
        show(integerResource1);
        put(integerResource1,10);
        show(integerResource2);
    }
}
