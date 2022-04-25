package com.angers.project.onjava8.stream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/24 08:58
 * @description : 流 - 使用 flatMap() 方法合并流
 * flatmap() 可以理解为降维函数，维度是 Stream
 * 和 map() 一样，flatMap() 也是接收 stream 并将方法中的函数运用到每一个元素中
 * 一般情况下，我们期望的是经过 map 加工后的流会变成元素流
 * 但是如果 map 中的函数的输出是流的话
 * 经过 map 处理的流就会编程元素流的流
 * 使用 flatMap 可以对其进行降维处理
 * 直接展开为元素
 */
public class CombiningStreamsWithFlatMap {
    public static void main(String[] args) throws IOException {
        Stream.of(1,2,3,4,5)
                // 这一步，将每一个元素转换成 stream
                .map( i -> Stream.of(i+1,i+2,i+3) )
                // 期望获取每个元素的 class 名
                .map(Object::getClass)
                // 实际获取的是 stream 的 class 名
                .forEach(System.out::println);

        Stream.of(1,2,3,4,5)
                // 经过 flatMap 加工后的数据未 Stream(Integer)
                .flatMap( i -> Stream.of(i+1,i+2,i+3) )
                .forEach(System.out::print);

        Random random = new Random(93);
        Stream.of(1,2,3,4,5)
                        .flatMapToInt(i -> IntStream.concat(
                                random.ints(1,100).limit(1),
                                IntStream.of(-1)))
                                .forEach(System.out::println);

        Files.lines(Paths.get(Paths.get(CommonUtils.FILE_PATH) + "/notice.txt"))
                .skip(5)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line))
                .limit(10)
                .map(v -> v + " ")
                .forEach(System.out::print);
    }
}