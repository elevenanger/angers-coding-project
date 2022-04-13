package com.angers.project.onjava8.polymorphism.music;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/12 17:12
 * @description : 多态-音乐-扩展
 */
public class MusicPlus {
    // 不关心对象类型，即使新增类型也可以正常运行
    public static void tuneAll(Instrument [] instruments){
        Arrays.stream(instruments).forEach(v -> v.play(Note.B_FLAT));
    }
    public static void adjustAll(Instrument [] instruments){
        Arrays.stream(instruments).forEach(Instrument::adjust);
    }
    public static void whoIAm(Instrument [] instruments){
        Arrays.stream(instruments)
                .map(Instrument::what)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        // 添加到数组时完成向上转换
        Instrument [] orchestra = {
                new Wind(),
                new Woodwind(), // 新增类型
                new Brass(),
                new Stringed()
        };
        MusicPlus.tuneAll(orchestra);
        MusicPlus.adjustAll(orchestra);
        MusicPlus.whoIAm(orchestra);
        /* output:
        Wind.play() B_FLAT
        Woodwind.play() B_FLAT
        Brass.play() B_FLAT
        Stringed.play() B_FLAT
        Adjusting Wind
        Adjusting Woodwind
        Adjusting Brass
        Adjusting Stringed
        Wind
        Woodwind
        Brass
        Stringed
         */
    }
}

class Woodwind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    String what() {
        return "Woodwind";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Woodwind");
    }
}