package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 09:48
 * @description : 泛型-模板方法
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator creator = new XCreator();
        System.out.println(creator);
    }

}

abstract class GenericWithCreate<T> {
    final T element ;

    GenericWithCreate() {
        this.element = create();
    }

    abstract T create();
}

class X {}
class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    @Override
    public String toString() {
        return "XCreator{" +
                getClass().getSimpleName() +
                '}';
    }
}