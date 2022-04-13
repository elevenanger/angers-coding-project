package com.angers.project.onjava8.polymorphism.music;

/**
 * @author : liuanglin
 * @date : 2022/4/12 14:27
 * @description : 使用方法重载替代多态
 */
public class Music2 {
    public static void tune(Brass brass){
        brass.play(Note.B_FLAT);
    }
    public static void tune(Stringed stringed){
        stringed.play(Note.B_FLAT);
    }
    public static void tune(Wind wind){
        wind.play(Note.B_FLAT);
    }
    public static void main(String[] args) {
        /*
        使用重载需要为每一个派生类型参数写一个方法
        多态则只需要通过基类调用
         */
        Music2.tune(new Wind());
        Music2.tune(new Brass());
        Music2.tune(new Stringed());

        Music.tune(new Wind());
        Music.tune(new Brass());
        Music.tune(new Stringed());

        /* output
        Wind.play() B_FLAT
        Brass.play() B_FLAT
        Stringed.play() B_FLAT
        Wind.play() B_FLAT
        Brass.play() B_FLAT
        Stringed.play() B_FLAT
         */
    }
}

class Stringed extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    String what() {
        return "Brass";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }
}