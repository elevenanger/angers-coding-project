package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 09:01
 * @description : 多个构造函数之间通过 this 关键字互相调用
 */
public class Flower {

    int petalCount = 0;

    String s = "initial value ";

    Flower(int petals){
        petalCount = petals;
        System.out.println("Constructor w/ int arg only , PetalCounts = " + petalCount);
    }

    Flower(String ss){
        s = ss;
        System.out.println("Constructor w/ String arg only , desc = " + s);
    }

    Flower(String sss,int petals){
        /*
        在构造函数中，当你给 this() 一个参数列表时，它对该参数列表匹配的构造函数进行显式调用
        如果需要在一个构造函数中调用其它的构造函数
        这个调用只能进行一次，而且是必须是第一条语句
         */
        this(petals);
        this.s = sss; // this 在这里指“这个对象”或“当前对象”，它本身会产生对当前对象的引用
        System.out.println("Constructor w/ String & int args  , desc = " + s  + " ,petalCount = " + petalCount);
    }

    Flower(){
        this("hi",47);
        System.out.println("Zero argument constructor.");
    }

    void printPetalCounts(){
        System.out.println("desc = " + s  + " ,petalCount = " + petalCount);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCounts();
    }
}
