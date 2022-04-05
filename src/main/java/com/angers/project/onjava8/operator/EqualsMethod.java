package com.angers.project.onjava8.operator;

import java.util.Objects;

public class EqualsMethod {

    public static void main(String[] args) {
        ValA valA1 = new ValA();
        ValA valA2 = new ValA();
        valA1.i = valA2.i = 100;
        /*
        equals 方法默认比较的是对象的引用  return (this == obj);
        valA1 和 valA2 是两个不同的对象，比较结果为 false
         */
        System.out.println(valA1.equals(valA2));

        ValB valB1 = new ValB();
        ValB valB2 = new ValB();
        valB1.i = valB2.i = 100;
        /*
        使用重写的方法，比较 i 的值
        返回为 true
         */
        System.out.println(valB1.equals(valB2));
    }
}

class ValA {

    int i;

}

class ValB {

    int i;

    /**
     * 重写对象的 equals 方法
     * @param o 比较的对象
     * @return 比较值
     */
    @Override
    public boolean equals(Object o) {
        ValB valB = (ValB) o;
        return i == valB.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

}
