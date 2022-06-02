package com.angers.project.onjava8.compare;

import java.util.Objects;

/**
 * @author : liuanglin
 * @date : 2022/6/2 09:18
 * @description : 简化比较方法
 */
public class SuccinctEquality extends Equality {
    public SuccinctEquality(int i, String s, double d) {
        super(i, s, d);
        System.out.println("SuccinctEquality.SuccinctEquality");
    }

    @Override
    public boolean equals(Object rVal) {
        return rVal instanceof SuccinctEquality &&
                Objects.equals(i,((SuccinctEquality) rVal).i) &&
                Objects.equals(s,((SuccinctEquality) rVal).s) &&
                Objects.equals(d,((SuccinctEquality) rVal).d) ;
    }

    public static void main(String[] args) {
        Equality.testAll(SuccinctEquality::new);
    }
}
