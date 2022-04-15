package com.angers.project.onjava8.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * @author : liuanglin
 * @date : 2022/4/14 15:04
 * @description : 接口-实现接口以符合特定的方法
 */
public class RandomStrings implements Readable{
    private static Random random = new Random(93);
    private static final char[] CAPITALS = "ABCDEFGHIJKL".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();
    private int count;

    public RandomStrings(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;
        cb.append(CAPITALS[random.nextInt(CAPITALS.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(VOWELS[random.nextInt(VOWELS.length)]);
        }
        cb.append(" ");
        return 6;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new RandomStrings(10))){
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }
    }
}


