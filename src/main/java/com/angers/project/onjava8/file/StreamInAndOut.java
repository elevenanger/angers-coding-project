package com.angers.project.onjava8.file;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/29 16:10
 * @description :文件-将文件转成流进行读写操作
 */
public class StreamInAndOut {
    public static void main(String[] args) {
        // 读取文件转输入流
        try (Stream<String> in = Files.lines(Paths.get(CommonUtils.FILE_PATH,"notice.txt"));
             // 写文件输出流
             PrintWriter out = new PrintWriter("text.txt");){
            in.map(String::toUpperCase)
                    .forEachOrdered(out::println);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
