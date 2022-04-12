package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 15:39
 * @description : 组合使用 public 对象
 * 当你需要在新建的类中包含现有类已有的功能，而不是它的接口的情况下使用组合
 */
public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door left = new Door();
    public Door right = new Door();
    public Car(){
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollUp();
        car.wheels[1].inflate();
    }
}

class Engine {
    public void start(){}
    public void stop() {}
}

class Wheel {
    public void inflate(){}
}

class Window {
    public void rollUp(){}
    public void rollDown(){}
}

class Door {
    public Window window = new Window();
    public void open(){}
    public void close(){}
}