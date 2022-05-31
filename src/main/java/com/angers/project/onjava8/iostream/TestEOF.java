package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/5/31 09:16
 * @description : 检查输入流还剩余多少可读取的数据
 */
public class TestEOF {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        Files.newInputStream(Paths.get(CommonUtils.IO_FILE_PATH+ "TestEOF.java"))
                )
        )){
            // available() 方法检查剩余多少字符
            while(in.available() > 0)
                System.out.write(in.readByte());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
