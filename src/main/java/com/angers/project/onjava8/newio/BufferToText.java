package com.angers.project.onjava8.newio;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/1 08:36
 * @description : 将缓冲区的字节数据转换成字符文本数据
 */
public class BufferToText {

    private static File file= Paths.get(CommonUtils.NIO_FILE_PATH,"data.txt").toFile();

    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream(file).getChannel()){
            fc.write(ByteBuffer.wrap("Some Bytes".getBytes()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(FileChannel fc = new FileInputStream(file).getChannel()){
            fc.read(buffer);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        buffer.flip();
        // 不生效
        System.out.println(buffer.asCharBuffer());
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        // 使用系统的文件编码进行解码
        System.out.println("Decoding using " + encoding + " : "
            + Charset.forName(encoding).decode(buffer));
        try (FileChannel fc = new FileOutputStream(file).getChannel()){
            fc.write(ByteBuffer.wrap("Some text".getBytes(StandardCharsets.UTF_16BE)));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        buffer.clear();
        try (FileChannel fc = new FileInputStream(file).getChannel()){
            fc.read(buffer);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        buffer = ByteBuffer.allocate(29);
        buffer.asCharBuffer().put("some more text");
        try (FileChannel fc = new FileOutputStream(file).getChannel()){
            fc.write(buffer);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        buffer.clear();
        try (FileChannel fc = new FileInputStream(file).getChannel()){
            fc.read(buffer);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
