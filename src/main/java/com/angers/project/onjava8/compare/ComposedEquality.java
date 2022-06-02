package com.angers.project.onjava8.compare;

import java.util.Objects;

/**
 * @author : liuanglin
 * @date : 2022/6/2 09:21
 * @description : Objects.equals() 对于组合类的对象之间的比较非常有效
 */
class Part {
    String ss;
    double dd;

    public Part(String ss, double dd) {
        this.ss = ss;
        this.dd = dd;
    }

    @Override
    public boolean equals(Object rVal) {
        // equals() 方法的标准写法
        return rVal instanceof Part &&
                Objects.equals(ss,((Part) rVal).ss) &&
                Objects.equals(dd,((Part) rVal).dd) ;
    }
}

public class ComposedEquality extends SuccinctEquality {
    Part part;

    public ComposedEquality(int i, String s, double d) {
        super(i, s, d);
        this.part = new Part(s,d);
        System.out.println("ComposedEquality.ComposedEquality");
    }

    @Override
    public boolean equals(Object rVal) {
        return rVal instanceof ComposedEquality &&
                super.equals(rVal) &&
                // 使用 Objects.equals() 进行比较
                Objects.equals(part,((ComposedEquality) rVal).part);
    }

    public static void main(String[] args) {
        Equality.testAll(ComposedEquality::new);
    }
}
