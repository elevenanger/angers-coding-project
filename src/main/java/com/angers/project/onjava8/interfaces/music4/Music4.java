package com.angers.project.onjava8.interfaces.music4;

import com.angers.project.onjava8.polymorphism.music.Note;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/13 15:06
 * @description : 抽象类与方法
 */
public class Music4 {
    static void tune(Instrument instrument){
        instrument.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument [] instruments){
        Arrays.stream(instruments).forEach(Music4::tune);
    }

    public static void main(String[] args) {
        Instrument [] instruments = {
                new Brass(),
                new Wind(),
                new Woodwind()
        };
        tuneAll(instruments);
        /* output
        Brass.play() MIDDLE_C
        Wind.play() MIDDLE_C
        Woodwind.play() MIDDLE_C
         */
    }
}

abstract class Instrument {
    private int i;
    public abstract void play(Note note);
    public String what(){
        return "Instrument";
    }
    public abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " +note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjust Wind");
    }

    @Override
    public String what() {
        return "Wind";
    }
}

class Brass extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjust Brass");
    }

    @Override
    public String what() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    public void adjust() {
        System.out.println("Adjust Woodwind");
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}