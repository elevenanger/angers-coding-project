package com.angers.project.onjava8.stream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/23 10:54
 * @description : 流 - 生成器模式生成 Stream
 * 生成器设计模式：
 * 创建一个生成器对象
 * 给予其构造函数必要的信息
 * 执行生成动作生成目标对象
 */
public class StreamBuilders {
    // 生成器
    Stream.Builder<String> builder = Stream.builder();
    // 通过入参，执行构造函数，往生成器中添加元素
    public StreamBuilders(String filename) throws IOException {
        Files.lines(Paths.get(CommonUtils.FILE_PATH + filename))
                .skip(10)
                .forEach(line -> {
                    for (String word: line.split("[ .,?!-()]+")) {
                        builder.add(word);
                    }
                });
    }
    /*
    使用生成器创建对象
    在调用 build 方法之前都可以不断往 builder 添加元素
    一旦调用 build 方法之后则无法再添加元素至 builder 中
     */
    Stream<String> words(){
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        new StreamBuilders("notice.txt")
                .words()
                .limit(20)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
