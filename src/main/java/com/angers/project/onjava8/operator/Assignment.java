package com.angers.project.onjava8.operator;

public class Assignment {

    public static void main(String[] args) {

        /*
        基元变量保存实际值而不是对对象的引用
        对基元类型变量进行赋值时，将运算符右侧的内容拷贝到左侧
         */
        int a = 9;
        int b = 3;
        System.out.println("1:a = "+a + ",b = " + b);
        a = b; // 将 b 的值赋给 a
        System.out.println("2:a = "+a + ",b = " + b);
        a = 10; // a 再次赋值 ，a 的值发生的变化，b 的值不变
        System.out.println("3:a = "+a + ",b = " + b);

        /*
        操作一个对象，实际是操作对象的引用
        将一个对象赋值给另一个对象其实是将一个对象的引用复制给了另一个对象
         */
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 3;
        System.out.println("1:t1.level = "+t1.level + ",t2.level = " + t2.level);
        /*
        这种赋值将不会改变 t1 和 t2 的引用，它们任然是两个独立的对象
        但是直接操作对象中的域未被 java 的设计原则
         */
        t1.level = t2.level;
        System.out.println("2:t1.level = "+t1.level + ",t2.level = " + t2.level);
        t1.level = 10;
        System.out.println("3:t1.level = "+t1.level + ",t2.level = " + t2.level);
        t1 = t2; // 将 t2 赋值给 t1 ,t1 和 t2 变量的对象引用变为同一个
        System.out.println("4:t1.level = "+t1.level + ",t2.level = " + t2.level);
        t1.level = 27; // 操作 t1 ,实际是操作 t1 所引用的对象，t1 t2 引用同一个对象，所以 level 是相同的
        System.out.println("5:t1.level = "+t1.level + ",t2.level = " + t2.level);

    }
}
