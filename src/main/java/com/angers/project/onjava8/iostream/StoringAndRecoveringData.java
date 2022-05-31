package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Paths.*;

/**
 * @author : liuanglin
 * @date : 2022/5/31 15:36
 * @description : 存储并取回数据
 */
public class StoringAndRecoveringData {
    static Path path = get(CommonUtils.IO_FILE_PATH, "data.txt");
    public static void main(String[] args) {
        /*
        使用 DataOutputStream 写的数据
        Java 可以确保一定能够通过 DataInputStream 读取回来
         */
        try (DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(Files.newOutputStream(path)))){
            out.writeDouble(3.14);
            out.writeUTF("That was pi");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (DataInputStream in = new DataInputStream(
            new BufferedInputStream(Files.newInputStream(path)))){
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
