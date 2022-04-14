package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/13 10:18
 * @description : 多态-使变形
 * 使用组合动态改变对象的行为 (状态 设计模式)
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
        /* output:
        Stage 对象包含 Actor 对象的引用
        Actor 对象初始化为 HappyActor
        performPlay() 产生特定的行为
        因为对象引用可以在运行时进行替换
        Actor 对象可以重新绑定为 SadActor
        performPlay() 行为将会随之变化
        可以在运行时获得动态变化的灵活性（状态 设计模式）
        与之相对的是
        你不能在运行时以不同的方式继承
        继承的方式必须在编译阶段决定
        Tips：
        使用继承来表达不同的行为 HappyActor.act() SadActor.act()
        使用域来表达不同的状态 Stage - private Actor actor

        HappyActor
        SadActor
         */
    }
}

class Actor {
    public void act(){}
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();
    public void change(){
        actor = new SadActor();
    }
    public void performPlay(){
        actor.act();
    }
}