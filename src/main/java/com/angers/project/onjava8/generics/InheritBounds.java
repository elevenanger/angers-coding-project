package com.angers.project.onjava8.generics;

/**
 * @author : liuanglin
 * @date : 2022/5/9 14:14
 * @description :
 */
public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 = new Solid2<>(new Bounded());
        solid2.getColor();
        solid2.getX();
        solid2.weight();
    }

}

class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class WithColor2 <T extends HasColor> extends HoldItem<T> {
    public WithColor2(T item) {
        super(item);
    }
    java.awt.Color getColor(){
        return item.getColor();
    }
}

class WithColorCoord2<T extends Coord & HasColor> extends WithColor2<T>{
    public WithColorCoord2(T item) {
        super(item);
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

class Solid2<T extends Coord & HasColor & Weight > extends WithColorCoord2<T> {
    public Solid2(T item) {
        super(item);
    }

    int weight(){
        return item.weight();
    }
}