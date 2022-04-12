package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 11:30
 * @description : 继承，有参数的构造函数
 */
public class Chess extends BoardGame{
    public Chess() {
        /*
        如果基类没有无参构造函数
        必须使用 super 关键字显式地调用基类，并且传入合适的参数列表
        并且这个调用必须是派生类构造函数的第一个操作
         */
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess chess = new Chess();
        /* output
        Game constructor 11
        BoardGame constructor
        Chess constructor
         */
    }
}

class Game {
    Game (int i){
        System.out.println("Game constructor " + i);
    }
}

class BoardGame extends Game {
    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor ");
    }
}