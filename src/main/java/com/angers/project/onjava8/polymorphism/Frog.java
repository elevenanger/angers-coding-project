package com.angers.project.onjava8.polymorphism;

/**
 * @author : liuanglin
 * @date : 2022/4/13 08:50
 * @description : 多态-frog 继承与清理
 */
public class Frog extends Amphibian {
    private Characteristic characteristic = new Characteristic("Croaks");
    private Description description = new Description("Eat bugs");
    public Frog() {
        System.out.println("Frog()");
    }
    @Override
    protected void dispose() {
        System.out.println("Dispose Frog");
        characteristic.dispose();
        description.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.dispose();
        /* output:
        Creating Characteristic Is alive
        Creating Description Basic Living Creature
        LivingCreature()
        Creating Characteristic  Has heart
        Creating Description Animal not vegetable
        Animal()
        Creating Characteristic Can live in the water
        Creating Description Both water and land
        Amphibian()
        Creating Characteristic Croaks
        Creating Description Eat bugs
        Frog()
        Dispose Frog
        Dispose Characteristic Croaks
        Dispose Description Eat bugs
        Dispose Amphibian
        Dispose Characteristic Can live in the water
        Dispose Description Both water and land
        Dispose Animal
        Dispose Characteristic  Has heart
        Dispose Description Animal not vegetable
        Dispose LivingCreature
        Dispose Characteristic Is alive
        Dispose Description Basic Living Creature
         */
    }
}

class Characteristic {
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " +s);
    }

    protected void dispose(){
        System.out.println("Dispose Characteristic " +s);
    }
}

class Description {
    private String s;
    public Description(String s) {
        this.s = s;
        System.out.println("Creating Description " +s);
    }
    protected void dispose(){
        System.out.println("Dispose Description " +s);
    }
}

class LivingCreature {
    private Characteristic characteristic = new Characteristic("Is alive ");
    private Description description = new Description("Basic Living Creature ");
    public LivingCreature() {
        System.out.println("LivingCreature()");
    }
    protected void dispose(){
        System.out.println("Dispose LivingCreature ");
        characteristic.dispose();
        description.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic characteristic  = new Characteristic(" Has heart ");
    private Description description = new Description("Animal not vegetable ");
    public Animal() {
        System.out.println("Animal()");
    }
    @Override
    protected void dispose() {
        System.out.println("Dispose Animal ");
        characteristic.dispose();
        description.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal {
    private Characteristic characteristic = new Characteristic("Can live in the water");
    private Description description = new Description("Both water and land ");

    public Amphibian() {
        System.out.println("Amphibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("Dispose Amphibian");
        characteristic.dispose();
        description.dispose();
        super.dispose();
    }
}