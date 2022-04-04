package com.angers.project.onjava8.operator;

public class Equivalence {

    static void show (String desc, Integer n1, Integer n2){
        System.out.println("desc: "+desc);
        System.out.printf("%d==%d %b %b%n" , n1 ,n2, n1==n2,n1.equals(n2));
    }

    public static void test(int value){
        /*
        自动转换为 Integer 对象，会被转换为 Integer.valueOf()
        对于 Integer 的比较，应当使用 equals
        == , != 比较的是对象的引用
        Integer 的值 在 -128 ~ 127 之间，valueOf 方法将会对其进行缓存
        但是在此范围之外则未必
        所以在传入值为 128 时会得到不同的结果
        new Integer() , new Double() 等方法比 valueOf() 方法低效，应当尽量避免这种用法
         */
        Integer i1 = value;
        Integer i2 = value;
        show("Automatic",i1,i2);

        // 利用装箱机制，创建新的 Integer 对象
        Integer r1 = new Integer(value);
        Integer r2 = new Integer(value);
        show("new Integer()",r1,r2);

        // 等价于 [1]
        Integer v1 = Integer.valueOf(value);
        Integer v2 = Integer.valueOf(value);
        show("Integer.valueOf()",v1,v2);

        /*
        基元类型
        基元类型比较只能使用 == ，不能使用 equals
         */
        int x = value;
        int y = value;
        System.out.println("Primitive int:");
        System.out.printf("%d==%d %b%n" , x ,y, x==y);
    }

    public static void main(String[] args) {

        test(127);

        test(128);
    }

}
