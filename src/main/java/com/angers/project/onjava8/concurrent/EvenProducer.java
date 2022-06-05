package com.angers.project.onjava8.concurrent;


/**
 * @author : liuanglin
 * @date : 2022/6/5 20:31
 * @description :
 */
public class EvenProducer extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++ currentEvenValue;
        ++ currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenProducer());
    }
}
