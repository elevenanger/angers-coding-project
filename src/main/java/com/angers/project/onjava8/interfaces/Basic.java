package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 14:23
 * @description : 抽象类
 */
abstract class Basic {
    /*
    abstract 修饰抽象方法
    这是Java中未实现的方法
    只有方法声明，没有实现和方法体
    一个类存在一个或者多个抽象方法则必须声明为抽象类
     */
    abstract void unimplemented();

    public static void main(String[] args) {
        // Basic basic = new Basic() ;  抽象类无法直接实例化
    }
}

abstract class Basic2 extends Basic {
    abstract void unimplemented();
    public static void main(String[] args) {
        /*
        如果继承了抽象类，但是没有实现抽象的方法
        这个派生类任然是抽象类，无法实例化
         */
        // Basic2 basic2 = new Basic2() ;
    }
}

/*
继承抽象类
实现所有的抽象方法
即可以实例化变成非抽象类
可以实例化
 */
class InstantiableBasic extends Basic {
    @Override
    void unimplemented() {
        System.out.println("InstantiableBasic.unimplemented()");
    }

    public static void main(String[] args) {
        InstantiableBasic instantiableBasic = new InstantiableBasic();
        instantiableBasic.unimplemented();
        /* output:
        InstantiableBasic.unimplemented()
         */
    }
}