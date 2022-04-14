package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/13 09:38
 * @description : 多态-构造函数中调用多态方法
 */
public class PolyConstructor {
    public static void main(String[] args) {
        Glyph g = new RoundGlyph(9);
        /* output:
        初始化的实际过程：
        1、在任何事情发生之前，为对象分配的存储空间初始化为二进制的0
        2、调用 Glyph 构造函数，此时调用了覆盖的 RoundGlyph.draw（）方法，在 RoundGlyph 构造函数调用之前，radius 值被设置为 0
        3、RoundGlyph 成员变量按照声明的顺序进行初始化
        4、调用派生类 RoundGlyph 构造函数
        构造函数 tips：
        1、尽量做最少的事情将对象设置为一个良好的状态
        2、如果可以避免的话，尽量不要在构造函数中调用该类任何其它的方法
        3、唯一安全的方法是在基类中定义为 final 的方法

        Glyph before draw()
        RoundGlyph.draw() radius = 0
        Glyph after draw()
        RoundGlyph.RoundGlyph() radius = 9
         */
    }
}

class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph before draw()");
        draw();
        System.out.println("Glyph after draw()");
    }
}

class RoundGlyph extends Glyph{
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph() radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw() radius = " + radius);
    }
}