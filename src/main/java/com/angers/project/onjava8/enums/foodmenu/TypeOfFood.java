package com.angers.project.onjava8.enums.foodmenu;

import com.angers.project.onjava8.enums.EnumsRandomSelection;

import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/10 16:28
 */
public class TypeOfFood {
    public static void main(String[] args) {
        IntStream.range(0,10)
                        .forEach(value -> System.out.println(value + " " +
                                EnumsRandomSelection.randomSelection(Food.ChineseFood.class)));
        IntStream.range(0,10)
                .forEach(value -> System.out.println(value + " " +
                        EnumsRandomSelection.randomSelection(Food.WesternFood.class)));
        IntStream.range(0,10)
                .forEach(value -> System.out.println(value + " " +
                        EnumsRandomSelection.randomSelection(Food.Soap.class)));
    }
}
