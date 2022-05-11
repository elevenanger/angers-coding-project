package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.reflection.pets.Dog;

import java.util.function.Consumer;

/**
 * @author : liuanglin
 * @date : 2022/5/10 09:39
 * @description :使用 Java8 的函数传递机制实现灯塔模式
 */
public class AssistLatentType {
    public static void main(String[] args) {
        CommunicateA.perform(new PerfromingDogA(),PerfromingDogA::speak,PerfromingDogA::sit);
        CommunicateA.perform(new RobotA(),RobotA::speak,RobotA::sit);
    }
}

class PerfromingDogA extends Dog {
    public void speak () {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce(){}
}

class RobotA {
    public void speak() {
        System.out.println("Click");
    }

    public void sit() {
        System.out.println("Clank");
    }

    public void oilChange() {}
}

class CommunicateA {
    public static <P> void perform(P performer, Consumer<P> action1,Consumer<P> action2){
        action1.accept(performer);
        action2.accept(performer);
    }
}
