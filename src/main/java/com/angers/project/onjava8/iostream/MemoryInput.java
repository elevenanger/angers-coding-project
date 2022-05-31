package com.angers.project.onjava8.iostream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author : liuanglin
 * @date : 2022/5/31 08:50
 * @description : 读取内存中的数据
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        /*
        BufferedInputFile.read() 将文件中的数据读取为 String
        String 用于创建 StringReader() 对象
        StringReader.read() 逐个读取 String 中的字符将其展示在控制台上
         */
        StringReader in = new StringReader(
                BufferedInputFile.read(CommonUtils.IO_FILE_PATH + "MemoryInput.java"));
        int c;
        // read() 方法返回的结果为 int 类型数值，需要将其转换为 char
        while((c = in.read())!=-1)
            System.out.print((char) c);
    }
}
