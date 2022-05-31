package com.angers.project.onjava8.iostream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.*;

/**
 * @author : liuanglin
 * @date : 2022/5/31 08:41
 * @description :
 */

public class BufferedInputFile {
    public static String read(String filename) {
        try(BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
            return in.lines()
                    .collect(Collectors.joining("\n"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.out.print(
                read("BufferedInputFile.java"));
    }
}
