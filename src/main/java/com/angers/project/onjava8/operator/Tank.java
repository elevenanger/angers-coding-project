package com.angers.project.onjava8.operator;

public class Tank {
    /*
    作为类的成员变量，在初始化类对象时会被赋予默认值
    局部变量则必须在声明变量的时候赋值，不然会出现编译错误
     */
    int level;

    public static void main(String[] args) {

        Tank t1 = new Tank();
        System.out.println(t1.level);

    }

}

