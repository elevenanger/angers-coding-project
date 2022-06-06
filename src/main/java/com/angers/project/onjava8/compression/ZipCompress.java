package com.angers.project.onjava8.compression;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author : liuanglin
 * @date : 2022/6/6 16:13
 * @description : zip 压缩文件
 */
public class ZipCompress {
    public static void main(String[] args) {
        System.out.println("生成 zip 压缩包");
        try (FileOutputStream f =
            new FileOutputStream(
                Paths.get(CommonUtils.FILE_PATH,"test.zip").toFile());
             CheckedOutputStream csum =
                 new CheckedOutputStream(f,new Adler32());
             ZipOutputStream zos =
                 new ZipOutputStream(csum);
             BufferedOutputStream out =
                 new BufferedOutputStream(zos)){
            zos.setComment("Java zip 测试");
            try (InputStream in =
                new BufferedInputStream(
                    Files.newInputStream(
                        Paths.get(CommonUtils.FILE_PATH + "notice.txt")))){
                zos.putNextEntry(new ZipEntry("notice"));
                int c ;
                while ((c = in.read()) != -1) out.write(c);
                out.flush();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("从 zip 中读文件");
        try (FileInputStream fi =
                 new FileInputStream(CommonUtils.FILE_PATH + "test.zip");
             CheckedInputStream csumi =
                 new CheckedInputStream(fi,new Adler32());
             ZipInputStream in2 = new ZipInputStream(csumi);
             BufferedInputStream bis =
                 new BufferedInputStream(in2)){
            ZipEntry z ;
            while ((z = in2.getNextEntry()) != null) {
                int x;
                while ((x = bis.read()) != -1) System.out.write(x);
            }
            System.out.println(csumi.getChecksum().getValue());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        // 打开 Zip 文件的另一种方式
        try (ZipFile zf =
                 new ZipFile(
                     CommonUtils.FILE_PATH + "test.zip")){
            Enumeration e = zf.entries();
            while (e.hasMoreElements()){
                ZipEntry ze2 = (ZipEntry) e.nextElement();
                System.out.println("文件 ： " + ze2);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
