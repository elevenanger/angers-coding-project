package com.angers.project.onjava8.generics;


/**
 * @author : liuanglin
 * @date : 2022/5/9 15:03
 * @description :
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit [] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            fruits[0] = new Fruit();
        }catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[1] = new Orange();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
