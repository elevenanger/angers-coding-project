package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author : liuanglin
 * @date : 2022/5/31 09:31
 * @description :
 */
public class FileOutputShortcut {
    static final String file = "FileOutputShortcut.java";
    static final String outFile = "FileOutputShortcut.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(BufferedInputFile.read(CommonUtils.IO_FILE_PATH + file)));
                PrintWriter out = new PrintWriter(CommonUtils.IO_FILE_PATH + outFile);
                ){
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(CommonUtils.IO_FILE_PATH + outFile));
    }
}
