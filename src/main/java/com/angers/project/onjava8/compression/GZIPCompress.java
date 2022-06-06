package com.angers.project.onjava8.compression;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author : liuanglin
 * @date : 2022/6/6 15:16
 * @description :
 */
public class GZIPCompress {
    public static void main(String[] args) {
        try (InputStream in = new BufferedInputStream(
            Files.newInputStream(
                Paths.get(CommonUtils.FILE_PATH + "notice.txt")));
                BufferedOutputStream out =
                    new BufferedOutputStream(
                        new GZIPOutputStream(
                            Files.newOutputStream(
                                Paths.get(CommonUtils.FILE_PATH + "test.gz"))))){
            System.out.println("写文件 。。。 ");
            int c;
            while ((c = in.read()) != -1) out.write(c);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("读文件 。。。 ");
        try (BufferedReader in2 = new BufferedReader(
            new InputStreamReader(
                new GZIPInputStream(
                    Files.newInputStream(
                        Paths.get(CommonUtils.FILE_PATH,"test.gz")))))){
            in2.lines().forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
