package com.angers.project.onjava8.reflection;

/**
 * @author : liuanglin
 * @date : 2022/5/2 10:12
 * @description : 反射-通过对象类型构造对象
 */
class Building {}
class House extends Building {}
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        /*
        使用 Class.cast() 方法构造对象对象
        可以赋值给基类对象
         */
        House h = houseType.cast(b);
        h = (House) b;
    }
}