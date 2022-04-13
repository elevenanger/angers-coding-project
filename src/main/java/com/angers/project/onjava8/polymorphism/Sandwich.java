package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/12 18:50
 * @description : 构造函数调用顺序
 */
public class Sandwich extends PortableLunch {
    private Bread bread = new Bread();
    private Cheese cheese = new Cheese();
    private Lettuce lettuce = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
    /* output
    Meal()
    Lunch()
    PortableLunch()
    Bread()
    Cheese()
    Lettuce()
    Sandwich()
     */
}

class Meal {
    public Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    public Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    public Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    public Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    public Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    public PortableLunch() {
        System.out.println("PortableLunch()");
    }
}