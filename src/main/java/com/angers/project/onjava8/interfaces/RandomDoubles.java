package com.angers.project.onjava8.interfaces;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/14 15:32
 */
public interface RandomDoubles {
    Random RANDOM = new Random(93);
    default double next(){return RANDOM.nextDouble();}
    static void main(String [] args){
        RandomDoubles randomDoubles = new RandomDoubles() {};
        for (int i = 0; i < 7; i++) {
            System.out.println(randomDoubles.next());
        }
    }
}
