package com.angers.project.onjava8.generics;

import java.awt.*;

/**
 * @author : liuanglin
 * @date : 2022/5/9 11:09
 * @description : 泛型，使用 extends 关键字约束泛型的范围，可以使其使用约束范围的特性
 */
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.getColor();
        solid.getX();
        solid.getY();
        solid.weight();
    }
}

interface HasColor {
    java.awt.Color getColor();
}

class WithColor<T extends HasColor> {
    T item;

    public WithColor(T item) {
        this.item = item;
    }

    T getItem(){
        return item;
    }

    java.awt.Color getColor(){
        return item.getColor();
    }
}

class Coord {
    public int x,y,z;
}

class WithColorCoord<T extends Coord & HasColor> {
    T item ;

    public WithColorCoord(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    java.awt.Color getColor(){
        return item.getColor();
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }
}

interface Weight { int weight();}

/**
 * 和常规的规则一样 T 只能继承一个类，但是可以实现多个接口
 * @param <T> 类型参数
 */
class Solid<T extends Coord & HasColor & Weight>{
    T item;

    Solid(T item) {
        this.item = item;
    }
    T getItem(){
        return item;
    }
    java.awt.Color getColor(){
        return item.getColor();
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }

    int weight(){
        return item.weight();
    }
}

class Bounded extends Coord implements HasColor,Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
