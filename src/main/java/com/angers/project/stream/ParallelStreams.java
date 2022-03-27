package com.angers.project.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ParallelStreams {

    public static void main (String [] args){

        /*
        使用 stream ，可以很方便进行并行化操作
        这个过程是自动的
        但是前提是需要有一个并行流（parallel stream）
        通过 parallelStream() 方法，可以从任意的 collection 创建 parallel stream
        一旦 stream 处理并行化模式，当终止方法执行的时候，每一个过程流处理步骤都将会并行化执行
        操作都是无状态的，并且可以以任意的顺序执行
        在使用并行流的时候需要确保其执行的函数是可以安全地并行执行的
        最好的办法就是避免可变的状态
        不要为了加快操作速度而降 stream 转换了 parallel stream ，需要注意以下几点：
        1、并行化同样会带来额外的开销，只有在处理非常大的数据集才是值得的
        2、只有在需要处理的数据结构能够被有效拆分的前提下，使用 parallel stream
        3、parallel stream 占用的线程池，可能会阻塞其它的操作，比如网络访问，文件 I/O 等
        parallel 适合用于较大的内存中的数据集合的处理以及计算密集型应用
         */
        ArrayList<String> wordsArrayList = new ArrayList<>();
        wordsArrayList.add("some");
        wordsArrayList.add("thing");
        Stream<String> wordsParallelStream = wordsArrayList.parallelStream();
        wordsParallelStream.forEach(log::info);
        // parallel() 方法可以将任意的顺序流转换为并行流
        String [] words = {"and","customer","badminton","table tennis","basketball","runner"};
        wordsParallelStream = Arrays.stream(words).parallel();
        wordsParallelStream.forEach(log::info);

        int [] countShortWords = new int[12];
        wordsParallelStream = Arrays.stream(words).parallel();
        /*
        使用 countShortWords 来对数组中长度不超过12位的字符串进行统计
        这种写法是不安全的
        因为 forEach() 方法是多线程执行的，可能产生竞争条件导致每次运行的结果可能不一致
         */
        wordsParallelStream.forEach(word -> {if (word.length()<12) countShortWords[word.length()]++;});
        log.info(Arrays.toString(countShortWords));
        // 可以改为这种写法，安全地进行并行化计算
        wordsParallelStream = Arrays.stream(words).parallel();
        Map<Integer,Long> shortWordsCount  = wordsParallelStream
                .filter(word -> word.length() < 12)
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()));
        log.info(shortWordsCount.toString());

        wordsParallelStream = Arrays.stream(words).parallel();
        /*
        如果不在意结果的顺序，使用并发的方法效率会更高
         */
        Map<Integer, List<String>> result = wordsParallelStream
                .collect(Collectors
                        .groupingByConcurrent(
                                String::length));
        log.info(result.toString());
    }
}
