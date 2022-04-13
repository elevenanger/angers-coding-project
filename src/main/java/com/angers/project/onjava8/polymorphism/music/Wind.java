package com.angers.project.onjava8.polymorphism.music;

/**
 * @author : liuanglin
 * @date : 2022/4/12 11:30
 * @description : 管乐乐器
 */
public class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Wind");
    }
}
