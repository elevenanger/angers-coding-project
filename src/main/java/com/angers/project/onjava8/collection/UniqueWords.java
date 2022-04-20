package com.angers.project.onjava8.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/4/19 11:28
 * @description : 集合-set-列出文件中所有的单词
 */
public class UniqueWords {
    static final String FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project/src/main/java/com/angers/project/onjava8/collection/SetOperations.java";
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        lines.stream()
                .map(line -> line.split("\\W+"))
                        .map(Arrays::spliterator)
                                .forEach( array -> array
                                        .forEachRemaining(words::add));
        System.out.println(words);
    }
}
