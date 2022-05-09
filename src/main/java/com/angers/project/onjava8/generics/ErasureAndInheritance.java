package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/7 08:27
 * @description :
 */
public class ErasureAndInheritance {
    // 使用 SuppressWarnings 注解抑制未检查类型的赋值告警
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        // 未检查类型的赋值
        d2.set(obj);
    }
}
class GenericBase <T> {
    private T element;
    public void set(T arg) {element = arg;}
    public T get(){return element;}
}

class Derived1<T> extends GenericBase<T>{}

// 继承泛型类，但是没有泛型参数
class Derived2 extends GenericBase {}