package com.angers.project.onjava8.stream;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/23 16:44
 * @description : 流-将 String 通过正则表达式转换成流
 * 使用 regex.Pattern.splitAsStream() 方法可以很方便地将 String 通过正则匹配后转换成 Stream
 */
public class StringToWordsStreamRegexp {
    private final String all;

    /*
    将文件中的内容全部读取出来存放在 String 中
    但是这种做法存在问题
    文件中的内容必须存在内存中
    失去了 Stream 的最重要的特性
    1、不特别需要存储空间，Stream 对处理的数据进行分片只需要内存序列的片段，而不是处理数据全部加载进内存
    2、Stream 是懒处理的
     */
    public StringToWordsStreamRegexp(String filename) throws IOException {
        all = String.join("",
                Files.readAllLines(
                        Paths.get(CommonUtils.FILE_PATH + filename)));
    }
    /*
    使用 Pattern.compile() 方法用正则表达式处理字符串
    转换成 Stream
     */
    public Stream<String> stream(){
        return Pattern.compile("[\" ,.?/!]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        StringToWordsStreamRegexp string = new StringToWordsStreamRegexp("notice.txt");
        string.stream()
                .skip(3)
                .filter(w -> w.length() > 10) // filter() 对流中的元素进行过滤
                .distinct() // distinct() 也是过滤方法，对元素进行去重
                .limit(20)
                .peek(System.out::print)
                .sorted(Comparator.reverseOrder()) // sorted() 方法对流中的元素进行排序，可以传入 Comparator 函数定义排序方式
                .map(s -> s+" ") // 使用相同的函数处理 stream 中的每个元素
                .forEach(System.out::print);
    }
}
