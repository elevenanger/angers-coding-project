package com.angers.project.onjava8.polymorphism.shape;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/12 15:43
 * @description : 多态-动态绑定
 */
public class Shapes {
    public static void main(String[] args) {
        RandomShapes randomShapes = new RandomShapes();
        /*
        多态方法调用
        通过调用基类的接口，在接口调用时完成动态绑定
        执行派生类的方法和行为
         */
        Arrays.stream(randomShapes.array(10)).forEach(Shape::draw);
        /* output:
        Circle.draw()
        Square.draw()
        Circle.draw()
        Circle.draw()
        Square.draw()
        Circle.draw()
        Circle.draw()
        Square.draw()
        Circle.draw()
        Square.draw()
         */
    }
}
