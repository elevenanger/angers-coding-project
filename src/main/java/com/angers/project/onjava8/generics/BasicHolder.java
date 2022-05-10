package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 18:57
 * @description :
 */
public class BasicHolder <T>{
    T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    void f(){
        System.out.println(element.getClass().getSimpleName());
    }

}
class SubType extends BasicHolder<SubType> {
    public static void main(String[] args) {
        SubType t1 = new SubType();
        SubType t2 = new SubType();
        t1.setElement(t2);
        SubType t3 = t1.getElement();
        t1.f();
        t3.f();
    }

}