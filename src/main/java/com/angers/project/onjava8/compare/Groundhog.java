package com.angers.project.onjava8.compare;

/**
 * @author : liuanglin
 * @date : 2022/6/2 10:59
 * @description :
 */
public class Groundhog {
    protected int number ;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "number=" + number +
                '}';
    }
}