package com.angers.project.onjava8.polymorphism.music;

/**
 * @author : liuanglin
 * @date : 2022/4/12 11:30
 * @description : 乐器
 */
public class Instrument {
    public void play(Note note){
        System.out.println("Instrument.play() " +  note );
    }
    String what(){return "Instrument";};
    public void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
