package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 14:40
 * @description : 接口-没有抽象方法的抽象类
 * 可以创建这样的类防止实例化该类
 */
abstract public class AbstractWithoutAbstracts {
    static int f(){return 1;}

    public static void main(String[] args) {
        //AbstractWithoutAbstracts abstractWithoutAbstracts = new AbstractWithoutAbstracts(); 无法实例化
        System.out.println(AbstractWithoutAbstracts.f());
    }
}

