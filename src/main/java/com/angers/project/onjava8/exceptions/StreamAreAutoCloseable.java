package com.angers.project.onjava8.exceptions;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/25 20:48
 * @description : 异常 - Stream 是自动关闭的资源
 */
public class StreamAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (
                Stream<String> in = Files.lines(Paths.get(CommonUtils.FILE_PATH + "/notice.txt"));
                PrintWriter writer = new PrintWriter("notice.txt")
                ){
            in.skip(10)
                    .limit(1)
                    .map(String::toLowerCase)
                    .forEachOrdered(writer::println);
        }
    }
}
