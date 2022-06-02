package com.angers.project.onjava8.compare;

import java.util.Objects;

/**
 * @author : liuanglin
 * @date : 2022/6/2 11:16
 * @description :
 */
public class Groundhog2 extends Groundhog{
    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog2 &&
                Objects.equals(number,((Groundhog2) obj).number);
    }
}
