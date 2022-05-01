package com.angers.project.onjava8.reflection;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/30 17:30
 * @description :
 */
abstract class Shape {
    void draw(){
        System.out.println(this + ".draw()");
    }

    @Override
    public String toString() {
        return "Shape{}";
    }
}

class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle{}";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle{}";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square{}";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(),new Square(),new Triangle()
        };
        // 面向对象语言，对多态对象，执行动态对象类型绑定,这正是反射的一个基本特性
        Arrays.stream(shapes).forEach(Shape::draw);
    }
}
