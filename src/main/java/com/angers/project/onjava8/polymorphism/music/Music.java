package com.angers.project.onjava8.polymorphism.music;

/**
 * @author : liuanglin
 * @date : 2022/4/12 11:32
 * @description : 音乐
 */
public class Music {
    /**
     * 演奏发音
     * @param instrument 乐器类型
     */
    public static void tune(Instrument instrument){
        instrument.play(Note.B_FLAT);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        /*
        向上转换
        Music 接收了一个 Wind 的对象引用作为其参数
        Music.tune() 调用 Wind.play()
        将方法调用和方法体连接起来的动作称之为绑定
        在运行时发生的绑定称之为后期绑定
        实现后期绑定的语言必须具备某种机制在运行时决定对象的类型并调用合适的方法
        类型信息必须安装在对象中
        java中的方法除了 final 和 static 方法（ private 是隐式的 final 方法）
        其它方法都使用了后期绑定
         */
        Music.tune(flute);
        /* output
        Wind.play() B_FLAT
         */
    }
}
