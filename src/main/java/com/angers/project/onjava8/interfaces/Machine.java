package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 08:40
 * @description : 使用接口的 static 模板方法，接收任意实现该接口的对象，执行接口方法在各个类中的实现
 */
public class Machine {
    public static void main(String[] args) {
        Operations.runOps(
                new Bing(),
                new Crack(),
                new Twist()
        );
        /*
        output:
        Bing
        Crack
        Twist
         */
    }
}

class Bing implements Operations {
    @Override
    public void execute() {
        Operations.show("Bing");
    }
}

class Crack implements Operations {
    @Override
    public void execute() {
        Operations.show("Crack");
    }
}

class Twist implements Operations {
    @Override
    public void execute() {
        Operations.show("Twist");
    }
}