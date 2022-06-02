package com.angers.project.onjava8.compare;

import java.util.Objects;

/**
 * @author : liuanglin
 * @date : 2022/6/2 09:02
 * @description :
 */
public class Equality {
    protected int i;
    protected String s;
    protected double d;

    public Equality(int i, String s, double d) {
        this.i = i;
        this.s = s;
        this.d = d;
        System.out.println("Equality.Equality");
    }

    @Override
    public boolean equals(Object rVal) {
        if (rVal == null) return false;
        if (rVal == this) return true;
        if (!(rVal instanceof Equality)) return false;
        Equality other = (Equality) rVal;
        if (!Objects.equals(i,other.i)) return false;
        if (!Objects.equals(s,other.s)) return false;
        if (!Objects.equals(d,other.d)) return false;
        return true;
    }

    public void test(String descR,String expected,Object rVal){
        System.out.format("-- Testing %s --%n" +
                "%s instanceof Equality : %s%n " +
                "Expected %s , got %s%n",
                descR,descR,rVal instanceof Equality,
                expected,equals(rVal));
    }

    public static void testAll(EqualityFactory eqf){
        Equality e = eqf.make(1,"Monty",3.14);
        Equality eq = eqf.make(1,"Monty",3.14);
        Equality neq = eqf.make(99,"Bob",1.618);
        e.test("null","false",null);
        e.test("same object","true",e);
        e.test("different type","false",Integer.valueOf(99));
        e.test("same values","true",eq);
        e.test("different values","false",neq);
    }

    public static void main(String[] args) {
        testAll(Equality::new);
    }
}
