package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 11:09
 * @description : 继承中的构造函数调用
 */
public class Cartoon extends Drawing {
    public Cartoon(){
        System.out.println("Cartoon constructed.");
    }

    public static void main(String[] args) {
        /*
        继承不仅仅是拷贝基类的接口方法
        当创建一个派生类对象，它包含了一个基类对象的子对象
        基类对象子对象包装在派生对象中
        为了确保正确初始化基类对象子对象
        唯一的方式就是调用基类的构造函数
        Java 会自动往派生类的构造函数中插入基类的构造函数
         */
        Cartoon cartoon = new Cartoon();
        /* output
        Art constructed.
        Drawing constructed.
        Cartoon constructed.
         */
    }
}

class Art {
    Art(){
        System.out.println("Art constructed.");
    }
}

class Drawing extends Art {
    Drawing(){
        System.out.println("Drawing constructed.");
    }
}

