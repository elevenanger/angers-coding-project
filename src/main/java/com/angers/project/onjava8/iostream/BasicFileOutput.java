package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;

/**
 * @author : liuanglin
 * @date : 2022/5/31 08:36
 * @description : FileWriter 对象将数据写入文件
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read(CommonUtils.IO_FILE_PATH + "BasicFileOutput.java")));
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(CommonUtils.IO_FILE_PATH + file))
                )
        ){
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(BufferedInputFile.read(CommonUtils.IO_FILE_PATH + file));
    }
}
