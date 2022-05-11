package com.angers.project.onjava8.enums;

import com.angers.project.onjava8.housekeeping.Spiciness;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/10 16:02
 * @description : 随机选择枚举中的枚举类型
 */
public class EnumsRandomSelection {
    private static Random random = new Random(9);
    public static <T extends Enum<T>>  T randomSelection(Class<T> enumClass){
        return random(enumClass.getEnumConstants());
    }
    public static <T> T random(T [] values){
        return values[random.nextInt(values.length)];
    }

    public static void main(String[] args) {
        System.out.println(randomSelection(Spiciness.class));
        IntStream.range(0,10)
                .forEach(v -> System.out.println(v + " " + randomSelection(Spiciness.class)));
    }
}