package com.angers.project.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.zip.GZIPInputStream;

@Slf4j
public class InputAndOutputBasement {

    public static String FILE_PATH = "/Users/liuanglin/data/numberinput.txt.gz";

    public static void main (String [] args) throws IOException {
        File file = new File(FILE_PATH);
        /*
        Java 有一种比较聪明的机制分离两种职责：
        一些 input stream 可以将文件或者各种文件地址转换为字节(FileInputStream)
        其它一些 input stream 可以将字节转换为个有效的数据格式(DataInputStream)
        程序员需要将其组合起来使用
        下面这个例子，需要从 gzip 文件中读取数据
        1、从文件创建一个 FileInputStream
        2、因为是 gzip 格式文件，将 FileInputStream 作为参数传给 GZIPInputStream 构造器
        3、因为我们需要读取数值，将 GZIPInputStream 作为参数传给 DataInputStream 构造器
        4、通过以上顺序，可以使用 DataInputStream 中的方法读取有效的数据
         */
        try (FileInputStream fis = new FileInputStream(file);
                GZIPInputStream gis = new GZIPInputStream(fis);
                DataInputStream dis = new DataInputStream(gis);)
        {
            //
            int available = dis.available();
            log.info(Integer.toString(available));
            if (available>0){
                // 将字节转换为 int 类型数值
                int x = dis.readInt();
                log.info(Integer.toString(x));
            }
        }
    }

}
