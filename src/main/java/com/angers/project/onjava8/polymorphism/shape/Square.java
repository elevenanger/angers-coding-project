package com.angers.project.onjava8.polymorphism.shape;

/**
 * @author : liuanglin
 * @date : 2022/4/12 15:24
 * @description : 四方形
 */
public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }
}
