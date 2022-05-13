package com.angers.project.onjava8.enums;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/5/12 08:30
 * @description : 枚举-状态机设计模式
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        @Override
        int amount() {
            throw new RuntimeException("ABORT");
        }
    },
    STOP{
        @Override
        int amount() {
            throw new RuntimeException("STOP");
        }
    };

    int value;

    Input(int value) {
        this.value = value;
    }

    Input(){

    }

    int amount() {
        return value;
    }
    static Random random = new Random(9);

    public static Input randomSelection(){
        return values()[random.nextInt(values().length -1)];
    }
}
