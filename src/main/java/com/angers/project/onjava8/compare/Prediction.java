package com.angers.project.onjava8.compare;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/6/2 11:00
 * @description :
 */
public class Prediction {
    private static Random random = new Random(93);

    @Override
    public String toString() {
        return "Prediction{}" +
                (random.nextBoolean() ?
                        "six more weeks for winter" :
                        "early spring");
    }
}
