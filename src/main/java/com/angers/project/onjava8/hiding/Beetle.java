package com.angers.project.onjava8.hiding;

/**
 * @author : liuanglin
 * @date : 2022/4/12 10:49
 * @description : 初始化的所有程序
 */
public class Beetle  extends Insect {
    private int k = printInit("Beetle.k is initialized.");
    private int x2  = printInit("Beetle.x2 initialized.");

    public Beetle() {
        System.out.println(" k = " + k);
        System.out.println(" j = " + j);
    }

    @Override
    public String toString() {
        return "Beetle{" +
                "k=" + k +
                ", x2=" + x2 +
                ", j=" + j +
                '}';
    }

    public static void main(String[] args) {
        Beetle beetle = new Beetle();
        System.out.println(beetle.toString());
        /* output:
        static Insect.x1 initialized.
        i= 9 j = 0
        Beetle.k is initialized.
        Beetle.x2 initialized.
        k = 93
        j = 93
        Beetle{k=93, x2=93, j=93}
         */
    }
}

class Insect {
    private int i = 9;
    protected int j;
    public Insect() {
        System.out.println("i= " + i + " j = " +j);
        j = 93;
    }
    private int x1  = printInit("static Insect.x1 initialized.");
    static int printInit(String s){
        System.out.println(s);
        return 93;
    }
    @Override
    public String toString() {
        return "Insect{" +
                "i=" + i +
                ", j=" + j +
                ", x1=" + x1 +
                '}';
    }
}
