package com.angers.project.corejava.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Slf4j
public class ZipStream {

    public static String FILE_PATH = "/Users/liuanglin/data/notice.txt";

    public static void main (String [] args) throws IOException {
        File noticeFile = new File(FILE_PATH+"NOTICE.zip");
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(
                        new FileOutputStream(FILE_PATH+"out.zip"));
                InputStream inputStream = Files.newInputStream(Paths.get(FILE_PATH));
                ){
            ZipEntry zipEntry = new ZipEntry("noticeOut.txt");
            zipOutputStream.putNextEntry(zipEntry);
            // Files 类可以快读处理常见的文件操作，这些操作用于处理中等长度的文本文件
            zipOutputStream.write(Files.readAllBytes(Paths.get(FILE_PATH)));
            zipOutputStream.closeEntry();
            // Files 类也可以用 io 流的形式处理大文件或者二进制文件
            zipEntry = new ZipEntry("noticeStream.txt");
            zipOutputStream.putNextEntry(zipEntry);
            while (inputStream.available()>0){
                zipOutputStream.write(inputStream.read());
            }
            zipOutputStream.closeEntry();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(
                new FileInputStream(noticeFile))){
            ZipEntry entry;
            // getNextEntry 返回压缩包中的下一个文件
            while ((entry = zipInputStream.getNextEntry()) != null){
                log.info(entry.toString());
                // 调用 closeEntry 读取下一个文件
                zipInputStream.closeEntry();
            }
        }
    }
}
