package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.reflection.pets.Cat;

/**
 * @author : liuanglin
 * @date : 2022/5/5 18:30
 * @description : 泛型-使用基类 Object 定义对象类型
 */
public class Holder2 {
    private Object a ;

    /**
     * Object 定义对象类型
     * 可以传入任意类型的对象
     * 一般对于集合来说，很少需要储存各种不同类型的对象
     * 只能够往特定集合添加相同类型的对象
     * 所以相对 Object 来说
     * 需要一个类型占位符
     * 在实际使用的时候决定对象类型
     * @param a Object 对象
     */
    public Holder2(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 holder2  = new Holder2(new Cat());
        Cat cat = (Cat) holder2.getA();
        System.out.println(cat);
        holder2.setA("Not a Cat");
        String s = (String) holder2.getA();
        System.out.println(s);
        holder2.setA(1);
        Integer n = (Integer)holder2.getA();
        System.out.println(n);
    }
}
