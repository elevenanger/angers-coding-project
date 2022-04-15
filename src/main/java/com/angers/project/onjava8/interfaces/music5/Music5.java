package com.angers.project.onjava8.interfaces.music5;

import com.angers.project.onjava8.polymorphism.music.Note;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/14 09:14
 * @description : 接口-重构乐器家族
 */
public class Music5 {
    public static void main(String[] args) {
        Instrument [] instruments = {
                new Brass(),
                new Percussion(),
                new Stringed(),
                new Woodwind(),
                new Wind()
        };
        Instrument.tuneAll(instruments);
        /* output:
        Brass{} play C_SHARP
        Percussion{} play C_SHARP
        Stringed{} play C_SHARP
        Woodwind{} play C_SHARP
        Wind{} play C_SHARP
         */
    }
}

interface Instrument {
    int VALUE = 5;
    default void play(Note note){
        System.out.println(this + " play " + note);
    }
    default void adjust(){
        System.out.println("Adjusting " + this );
    }
    static void tune(Instrument instrument) {
        instrument.play(Note.C_SHARP);
    }
    static void tuneAll(Instrument ... instruments){
        Arrays.stream(instruments).forEach(Instrument::tune);
    }
}

class Wind implements Instrument {
    @Override
    public String toString() {
        return "Wind{}";
    }
}

class Percussion implements Instrument {
    @Override
    public String toString() {
        return "Percussion{}";
    }
}

class Stringed implements Instrument {
    @Override
    public String toString() {
        return "Stringed{}";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass{}";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind{}";
    }
}