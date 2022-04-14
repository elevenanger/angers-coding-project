package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/13 10:07
 * @description : 多态-协变返回类型：派生类中重写的方法可以返回基类中返回类型的派生类型
 */
public class CovariantReturn {
    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain grain = mill.process();
        System.out.println(grain);
        mill = new WheatMill();
        grain = mill.process();
        System.out.println(grain);
        /* output:
        Grain{}
        Wheat{}
         */
    }
}

class Grain {
    @Override
    public String toString() {
        return "Grain{}";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat{}";
    }
}

class Mill {
    Grain process(){
        return new Grain();
    }
}

class WheatMill extends Mill {
    /*
    重写基类 process 方法
    返回类型 Wheat 是 Grain 的派生类型
    这种情况下 @Override 注解不会报错
    协变返回类型允许返回的类型更精确
     */
    @Override
    Wheat process() {
        return new Wheat();
    }
}

