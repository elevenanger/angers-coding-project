package com.angers.project.onjava8.polymorphism.shape;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/12 15:28
 * @description : 多态-形状-工厂方法,随机生成一个 Shape 派生类对象
 */
public class RandomShapes {
    private Random random = new Random(93);
    public Shape get(){
        switch (random.nextInt(3)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
    public Shape[] array(int size){
        Shape[]shapes = new Shape[size];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }

    public static void main(String[] args) {
        RandomShapes randomShapes = new RandomShapes();
        Shape [] shapes = randomShapes.array(10);
        Arrays.stream(shapes)
                .map(Object::getClass)
                .forEach(System.out::println);
    }
}
