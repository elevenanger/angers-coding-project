package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 14:42
 * @description : 确保正确的清理
 */
public class CADSystem extends Shape{
    private Circle circle;
    private Triangle triangle;
    private Line [] lines  = new Line[3];
    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j,j*j);
        }
        circle = new Circle(1);
        triangle = new Triangle(1);
        System.out.println("Combined CAD Constructor");
    }

    @Override
    void dispose() {
        System.out.println("CADSystem.dispose()");
        triangle.dispose();
        circle.dispose();
        for (int i = lines.length - 1; i >= 0 ; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem s = new CADSystem(93);
        try {
            System.out.println(s.toString());
        } finally {
            s.dispose();
        }
        /* output
        演示了对象回收的机制
        每个对象都有一个类似 dispose 的回收方法
        根据顺序，先执行自己本身的回收动作再调用基类的回收方法
        在清理方法（在本例中为 dispose()）中
        必须注意基类和成员对象清理方法的调用顺序，以防一个子对象依赖于另一个子对象
        首先按照创建的相反顺序执行特定于当前的类的所有清理工作
        然后调用基类清理方法
        Shape constructor 94
        Shape constructor 0
        Drawing Line : 0 , 0
        Shape constructor 1
        Drawing Line : 1 , 1
        Shape constructor 2
        Drawing Line : 2 , 4
        Shape constructor 1
        Drawing Circle
        Shape constructor 1
        Drawing Triangle
        Combined CAD Constructor
        com.angers.project.onjava8.reuse.CADSystem@63961c42
        CADSystem.dispose()
        Erasing Triangle
        Shape dispose
        Erasing Circle
        Shape dispose
        Erasing Line : 2 , 4
        Shape dispose
        Erasing Line : 1 , 1
        Shape dispose
        Erasing Line : 0 , 0
        Shape dispose
        Shape dispose
         */
    }
}

class Shape {
    public Shape(int i) {
        System.out.println("Shape constructor " + i);
    }

    void dispose(){
        System.out.println("Shape dispose");
    }
}

class Circle extends  Shape {
    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle " );
    }
    @Override
    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle ");
    }

    @Override
    void dispose() {
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start;
    private int end;
    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println(
                "Drawing Line : " + start + " , " + end
        );
    }
    @Override
    void dispose() {
        System.out.println(
                "Erasing Line : " + start + " , " + end
        );
        super.dispose();
    }
}
