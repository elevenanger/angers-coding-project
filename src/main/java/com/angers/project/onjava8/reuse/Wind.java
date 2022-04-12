package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 16:45
 * @description : 继承与向上转型
 */
public class Wind extends Instrument{
    public static void main(String[] args) {
        Wind flute = new Wind();
        /*
        Wind 继承 Instrument
        将 Wind 的引用转换成 Instrument 的引用叫做 向上转换
        向上转换是安全的
        因为是把一个特定的类型转换成一个通用的类型
        派生类是基类的超集
        所以向上转换不需要显式地转换声明
         */
        Instrument.tune(flute);
    }
}
class Instrument {
    public void play(){}
    static void tune(Instrument instrument){
        instrument.play();
    }
}

