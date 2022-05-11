package com.angers.project.onjava8.enums.cartoons;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/10 15:49
 * @description : 枚举-实现接口
 * 枚举类全部直接集成 Enum.class ，编译器会将枚举类构造函数使用 static final 关键字修饰，无法再被继承
 * 但是枚举类可以实现接口
 */
enum CartoonCharacter implements Supplier<CartoonCharacter> {
    BATMAN,
    JOKER,
    SUPERMAN,
    FLASH,
    GREEN_LANTERN,
    AQUAMAN,
    WONDER_WOMEN;
    private Random random = new Random(93);

    @Override
    public CartoonCharacter get() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Supplier<T> arg){
        System.out.println(arg.get() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.AQUAMAN;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}