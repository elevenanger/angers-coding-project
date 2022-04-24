package com.angers.project.onjava8.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/23 09:54
 * @description : 流-使用 Supplier<T> 接口实现 Stream.generate() 创建无限流
 */
public class Generator implements Supplier<String> {
    Random random = new Random(93);
    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return "" + letters[random.nextInt(letters.length)];
    }

    private static int count = 0;
    static String ifinity() {
        return "infiniti "  + ++count;
    }
    public static void main(String[] args) {
        // 使用实现 Supplier 接口的类创建无限流
        String randWord = Stream.generate(new Generator())
                .limit(20)
                .collect(Collectors.joining(" " ));
        System.out.println(randWord);

        // 直接在 generate 方法中声明实现 Supplier<T> 接口的函数
        Stream.generate(() -> "ifiniti")
                .limit(10)
                .forEach(System.out::println);

        // 使用方法签名符合 Supplier 接口的方法
        Stream.generate(Generator::ifinity).
                limit(3)
                .forEach(System.out::println);
    }
}