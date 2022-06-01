package com.angers.project.onjava8.newio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/1 14:20
 * @description : 内存映射文件可以用于创建或者操作非常巨大难以加载进内存中的文件
 */
public class LargeMappedFiles {
    static int length = 0x8000000; // 128 MB

    static File file = Paths.get("/Users/liuanglin/data/test.dat").toFile();

    public static void main(String[] args) throws Exception{
        try (RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            MappedByteBuffer out = raf.getChannel().map(
                FileChannel.MapMode.READ_WRITE,0,length);
            for (int i = 0; i < length; i++) {
                out.put((byte) 'x');
            }
            System.out.println("Finished writing.");
            for (int i = length/2; i < (length/2 + 6); i++) {
                System.out.print((char) out.get(i));
            }
        }
    }
}
