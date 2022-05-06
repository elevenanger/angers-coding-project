package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.reflection.Person;

/**
 * @author : liuanglin
 * @date : 2022/5/5 18:27
 * @description :泛型-只包含单个对象的类
 */
public class Holder1 {
    /*
    只包含单个对象
    在代码中明确对象类型
     */
    private Person person;

    public Holder1(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
