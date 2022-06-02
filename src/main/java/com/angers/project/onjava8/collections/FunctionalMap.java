package com.angers.project.onjava8.collections;

import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/6/2 16:49
 * @description :
 */
public class FunctionalMap {
    public static void main(String[] args) {
        HTMLColors.MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter( v -> v.startsWith("Dark"))
                .map(v -> v.replaceFirst("Dark","Hot"))
                .forEach(System.out::println);
    }
}
