package com.angers.project.onjava8.newio;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/5/31 18:58
 * @description : 使用 通道 和缓冲区拷贝文件
 */
public class ChannelCopy {
    private static int BSIZE = 1024;
    private static File sourceFile = Paths.get(CommonUtils.NIO_FILE_PATH,"source.txt").toFile();
    private static File destFile = Paths.get(CommonUtils.NIO_FILE_PATH,"dest.txt").toFile();

    public static void main(String[] args) {
        // 创建读写 channel
        try (FileChannel source = new FileInputStream(sourceFile).getChannel();
            FileChannel dest = new FileOutputStream(destFile).getChannel()) {
            // 将数据从读 channel 读到缓冲区，然后从缓冲区写到写 channel
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while (source.read(buffer) != -1){
                buffer.flip();
                dest.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
