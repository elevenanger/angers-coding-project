package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : liuanglin
 * @date : 2022/5/31 09:00
 * @description : 使用 DataInputStream 读取 格式化 的数据
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        /*
        DataInputStream 是面向byte I/O 类
        必须使用 InputStream 类对象作为入参
        使用 InputStream 类可以将任意数据读取为字节码
         */
        try (DataInputStream in = new DataInputStream(
            // 接收 byte[] 作为入参
            new ByteArrayInputStream(
                BufferedInputFile.read(
                    CommonUtils.IO_FILE_PATH + "FormattedMemoryInput.java").getBytes(StandardCharsets.UTF_8)))){
            while(true)
                System.out.write((char)in.readByte());
        }catch (EOFException e){
            System.out.println("\nEND OF STREAM");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
