package com.angers.project.onjava8.polymorphism.shape;

/**
 * @author : liuanglin
 * @date : 2022/4/12 15:24
 * @description : 多态-三角形
 */
public class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}
