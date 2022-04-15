package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 14:08
 * @description : 组合多个接口
 */
public class Adventure {
    public static void t(CanFight canFight){canFight.fight();}
    public static void u(CanFly canFly){canFly.fly();}
    public static void v(CanSwim canSwim){canSwim.swim();}
    public static void w(ActionCharacter actionCharacter){actionCharacter.fight();}

    public static void main(String[] args) {
        Hero hero = new Hero();
        Adventure.t(hero);
        Adventure.u(hero);
        Adventure.v(hero);
        Adventure.w(hero);
        /*
        ActionCharacter Hero .fight()
        Hero .swim()
        Hero .swim()
        ActionCharacter Hero .fight()
         */
    }
}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
        System.out.println("ActionCharacter " + getClass().getSimpleName() + " .fight()");
    }
}

class Hero extends ActionCharacter implements CanSwim,CanFly,CanFight {
    /*
    创建一个类，组合了继承和对个接口
    继承的声明要在接口声明之前
    必须定义实现的接口的所有方法
    Hero 没有声明 fight（） 方法
    但是它继承的 ActionCharacter 有相同签名的方法
    当你创建了 Hero 对象
    你可以向上转型为它实现的接口或者继承的类
     */
    @Override
    public void swim() {
        System.out.println(getClass().getSimpleName() + " .swim()");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " .swim()");
    }
}
