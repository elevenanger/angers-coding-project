package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 14:33
 * @description : 对于基元类型，作为类的实例域，在类对象初始化时，如果未进行初始化，将会有一个默认值进行初始化
 */
public class InitialValues {

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;

    InitialValues reference; // 在实例域中定义一个对象的引用，不进行初始化，初始值为 null

    void printInitialValues(){
        System.out.println(" Data type    Initial value ");
        System.out.println(" boolean      " + t);
        System.out.println(" char         " + c);
        System.out.println(" byte         " + b);
        System.out.println(" short        " + s);
        System.out.println(" int          " + i);
        System.out.println(" long         " + l);
        System.out.println(" float        " + f);
        System.out.println(" double       " + d);
        System.out.println(" reference    " + reference);
    }

    public static void main(String[] args) {
        new InitialValues().printInitialValues();
    }
}
