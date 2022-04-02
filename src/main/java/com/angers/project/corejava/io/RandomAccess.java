package com.angers.project.corejava.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@Slf4j
public class RandomAccess {

    public static String FILE_PATH = "/Users/liuanglin/data/random.txt";

    public static void main(String [] args) throws IOException {

        File file = new File(FILE_PATH);
        log.info(Long.toString(file.length()));
        /*
        RandomAccessFile 用于对文件任意位置进行读写操作
        可以打开一个文件，用于读取或者读写操作
        r 表示只读权限
        rw 表示读写权限
         */
        try (RandomAccessFile randomRead = new RandomAccessFile(file,"r");
                RandomAccessFile randomWrite = new RandomAccessFile(file,"rw")){
            randomWrite.writeChars("write something");
            log.info(Long.toString(randomWrite.getFilePointer())); // 随机存取文件具有一个文件指针，用于表明下一个读写字节的位置
            // seek 将文件指针设置为文件任意字节位置，0~file.length
            long position = 12;
            randomRead.seek(position);
            StringBuilder builder = new StringBuilder();
            while (randomRead.getFilePointer()<file.length()){
                builder.append(randomRead.readChar());
            }
            log.info(builder.toString());
        }
    }
}
