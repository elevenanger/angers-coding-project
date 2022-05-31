package com.angers.project.onjava8.newio;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/5/31 18:35
 * @description : 生成通道
 */
public class GetChannel {
    private static File file= Paths.get(CommonUtils.NIO_FILE_PATH,"data.txt").toFile();

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        // 写文件
        try (FileChannel fco = new FileOutputStream(file).getChannel()){
            fco.write(ByteBuffer.wrap("Some thing".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 追加数据
        try (FileChannel fca = new RandomAccessFile(file,"rw").getChannel()){
            fca.position(fca.size());
            fca.write(ByteBuffer.wrap("Append something".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 读文件
        try (FileChannel fcr = new FileInputStream(file).getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
            fcr.read(byteBuffer);
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) System.out.write(byteBuffer.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        getChannel() 方法产生 FileChannel
        通过是非常基本的
        给它一个 byte 缓冲区
        用于读取或者写入数据
        并锁定文件以进行独占访问
         */
        System.out.flush();
    }
}
