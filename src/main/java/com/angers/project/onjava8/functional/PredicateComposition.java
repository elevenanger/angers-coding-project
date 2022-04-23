package com.angers.project.onjava8.functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/22 10:19
 * @description : 函数 - 组合 Predicate 函数
 */
public class PredicateComposition {
    static Predicate<String> f1 = s -> {
        System.out.println("f1");
        return s.contains("bar");
    };
    static Predicate<String> f2 = s -> {
        System.out.println("f2");
        return s.length() < 5;
    };
    static Predicate<String> f3 = s -> {
        System.out.println("f3");
        return s.contains("foo");
    };

    static Predicate<String> f4 = f1.negate().and(f2).or(f3);

    public static void main(String[] args) {
    /*
    组合多个 predicate
    f1:s.contains("bar") - "foobar" "bar"
    f1.negate() - "foobaz" "quickly" "hard"
    f2:s.length() < 5
    f1.negate().and(f2) - "hard"
    f3:s.contains("foo")
    f1.negate().and(f2).or(f3) - "foobar" "foobaz" "hard"
     */
        Stream.of("foobar","foobaz","bar","quickly","hard")
                .filter(f4)
                .forEach(System.out::println);
        Stream.of("fooba").filter(f4).forEach(System.out::println);
    }
}
