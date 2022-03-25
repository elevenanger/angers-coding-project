package com.angers.project.stream;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class CreateStream {

    public static Stream<String> codePoints(String code){
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i<code.length()){
            int j = code.offsetByCodePoints(i,1);
            result.add(code.substring(i,j));
            i = j;
        }
        return result.stream();
    }

    public static void main (String [] args){
        /*
        集合可以通过 Collection 接口中的方法转换为 stream
        数组也可以通过 Arrays.stream() 方法转换为 stream
         */
        String [] strings = {"and","bad","cad"};
        Stream<String> wordsStream = Arrays.stream(strings);
        log.info(Long.toString(wordsStream.count()));

        // 使用 empty 方法创建一个空 stream
        Stream<String> empty = Stream.empty();

        /*
        stream 有两种方式创建无限流
        generate 方法采用一个没有参数的函数（Supplier<T>）
        每当需要 stream 的值时，会调用该函数生成一个值
        可以用一下方法获得一个常量的值的stream
         */
        Stream<String> cons = Stream.generate(() -> "CONSTANT");
        // 或者一个随机数 stream
        Stream<Double> randomNumber =
                Stream.generate(Math::random)
                        .limit(100); // 使用 limit 进行限制

        /*
        产生一个类似于 0,1,2,3，... 这样的序列
        使用 iterate 方法
        它使用一个 seed 值，以及一个函数（UnaryOperator<T>）
        反复执行函数，应用于上一次执行的结果
        在这个例子中，序列的第一个元素是 seed ，值为 BigInteger.ZERO
        第二个元素为 f(seed)
        第三个元素 f(f(seed))
        以此类推
         */
        Stream<BigInteger> integers =
                Stream.iterate(BigInteger.ZERO,number -> number.add(BigInteger.ONE))
                        // peek 类似于懒加载的模式，生成一个与源 stream 相同元素的新 stream，只有在元素被使用的时候才调用该函数
                        .peek(number -> number.add(BigInteger.TEN))
                        .limit(1000);

        String [] words = {"some","but","and"};
        Stream<Stream<String>> result =
                Arrays.stream(words).
                        map(CreateStream::codePoints);

        Stream <String> flatResult = Arrays.stream(words)
                .flatMap(CreateStream::codePoints)
                .distinct() // 对 stream 进行转换，剔除重复项
                .sorted(Comparator.comparing(String::length).reversed()); // 对 stream 中的元素进行排序转换

        // 连接两个 stream , 第一个 stream 不能是无限 stream
        Stream<String> combinedStream = Stream.concat(codePoints("hellp"),codePoints("world"));

        /*
        终止操作，将 stream 转换为可以在程序中使用的非 stream 值
        输出字典序最大的字母
        Optional<T> 是 T 类型对象或者无对象的包装器
         */
        Optional<String> maxString = flatResult.max(String::compareToIgnoreCase);
        log.info("maxString:"+maxString.orElse(""));

        Optional<String> wordStartWithA = Arrays.stream(words)
                .map(String::toUpperCase)
                .filter(word -> word.startsWith("A"))
                .findFirst(); // 输出第一个符合条件的元素
        log.info(wordStartWithA.orElse(""));
    }
}
