package com.angers.project.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class PrimitiveTypeStreams {

    public static void main(String [] args){
        /*
        可以通过 Stream<Integer> 来收集 int 类型数值
        但是这种方式将每个元素使用 Integer 对象进行封装并不高效
        其它的基元类型数值也是同样的问题
        stream 有 IntStream , LongStream 等专门的库可以直接存放这些基元类型元素，不需要进行封装
        使用 IntStream.of 方法创建一个 IntStream
         */
        IntStream ints = IntStream.of(1,2,3,4,5);
        ints.forEach(value -> log.info(""+value));
        // 也可以使用 Arrays.stream 方法来创建
        int [] intsArray = {1,2,3,4,6};
        ints = Arrays.stream(intsArray,0,intsArray.length);
        ints.forEach(value -> log.info(""+value));

        /*
        将基元类型 stream 转换为对象 stream ，使用 boxed 方法
         */
        ints = Arrays.stream(intsArray,0,intsArray.length);
        Stream<Integer> integerStream = ints.boxed();
        integerStream.forEach(value -> log.info(""+value));
    }
}
