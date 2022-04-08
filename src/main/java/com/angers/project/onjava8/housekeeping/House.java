package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 15:01
 * @description : 构造一个 House 对象
 */
public class House {

    Window w1 = new Window(1);

    House(){
        System.out.println("House()");
        w3 = new Window(33);
    }

    House(int x){
        System.out.println("Overloaded House()");
        w2 = new Window(x);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);

}
