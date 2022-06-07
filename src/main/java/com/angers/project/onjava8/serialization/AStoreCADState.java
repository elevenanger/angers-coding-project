package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/6/7 09:26
 * @description : 存储 CAD 系统的信息
 */
enum Color {RED,BLUE,GREEN}

abstract class Shape implements Serializable {
    private int xPos;
    private int yPos;
    private int dimension;
    private static Random random  = new Random(99);
    private static int counter = 0;
    public abstract void setColor(Color newColor);
    public abstract Color getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "{" +
            " color=" + getColor() +
            " , xPos=" + xPos +
            ", yPos=" + yPos +
            ", dimension=" + dimension +
            '}';
    }

    public static Shape randomFactory() {
        int xVal = random.nextInt(100);
        int yVal = random.nextInt(100);
        int dim = random.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0 : return new Circle(xVal,yVal,dim);
            case 1 : return new Square(xVal,yVal,dim);
            case 2 : return new Line(xVal,yVal,dim);
        }
    }
}

class Circle extends Shape {
    private static Color color = Color.RED;
    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

class Square extends Shape {
    private static Color color = Color.RED;

    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

class Line extends Shape {
    private static Color color = Color.RED;
    /*
    尽管 Serializable 是自动进行的
    但是 static 域不会被序列化
    如果需要序列化 static 域
    必须在类中定义相应的方法
    反序列化同理
     */
    public static void serializeStaticState(ObjectOutputStream stream)
        throws IOException {
        stream.writeObject(color);
    }
    public static void deserializeStaticState(ObjectInputStream stream)
        throws IOException,ClassNotFoundException {
        color = (Color) stream.readObject();
    }

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    @Override
    public Color getColor() {
        return color;
    }
}

public class AStoreCADState {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(CommonUtils.FILE_PATH,"/serialization/CAD.dat");
        List<Class<? extends Shape>> shapeTypes =
            Arrays.asList(
                Circle.class,
                Square.class,
                Line.class);
        List<Shape> shapes =
            IntStream
                .range(0,10)
                .mapToObj(i -> Shape.randomFactory())
                .collect(Collectors.toList());
        shapes.forEach(shape -> shape.setColor(Color.GREEN));
        try (
            ObjectOutputStream out =
                new ObjectOutputStream(
                    Files.newOutputStream(path))
            ){
            out.writeObject(shapeTypes);
            // 序列化 Line 中的 static 域
            Line.serializeStaticState(out);
            out.writeObject(shapes);
        }
        System.out.println(shapes);
    }
}
