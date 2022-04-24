package com.angers.project.onjava8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/22 14:48
 * @description :流
 */
public class RandomWords implements Supplier<String> {

    Random random  = new Random(93);

    List<String> words = new ArrayList<>();

    public RandomWords(String fileName) throws IOException {
        List<String> lines = Files
                .readAllLines(
                        Paths.get(
                                "/Users/liuanglin/data/"+fileName));
        for (String line : lines){
            Collections.addAll(words,line.split("[ .?,:]+"));
        }
    }

    @Override
    public String toString() {
        return  words.stream()
                .collect(Collectors.joining(" "));
    }

    @Override
    public String get() {
        return words.get(random.nextInt(words.size()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv());
        System.out.println(
                Stream.generate(new RandomWords("notice.txt"))
                        .limit(20)
                        .collect(Collectors.joining(" ")));
    }
}
