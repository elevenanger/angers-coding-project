package com.angers.project.onjava8.stream;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/24 10:06
 * @description : 流- optional 处理
 * Optional 类似于一种逃生机制
 * 对于流的处理过程中，如果需要查找或者操作的某个元素不存在
 * 如果不妥善处理这种情况，继续进行后续的操作，可能会导致出错
 * Optional 类型对象可以解决这种问题
 * 流中一些操作不能确保预期的结果存在的场景下，返回 Optional 对象
 */
public class StreamOptional {
    private static final String DEFAULT = "default";
    Stream.Builder<String> builder = Stream.builder();
    public StreamOptional(String ... strings) {
        Arrays.stream(strings).forEach(builder::add);
    }
    private Stream<String> stream(){
        return builder.build();
    }

    static void creatingOptionals(String testName,Optional<String> optional){
        CommonUtils.printDivideLine(testName);
        System.out.println(optional.orElse("null"));
    }

    public static void main(String[] args) throws Exception {
        // 使用 builder 方法
        // 创建一个空的 stream
        Stream<String> empty = new StreamOptional().stream();
        /*
        返回 Optional stream 的操作
        Optional 可以在操作结果为空不满足预期的情况下自定义返回值
         */
        Optional<String> quitOption ;
        quitOption = empty.findFirst();
        System.out.println(quitOption.orElse("Nothing match here."));
        empty = new StreamOptional().stream();
        quitOption = empty.findAny();
        System.out.println(quitOption.orElse("Nothing match here."));
        empty = new StreamOptional().stream();
        quitOption = empty.max(String::compareToIgnoreCase);
        System.out.println(quitOption.orElse("Nothing match here."));
        empty = new StreamOptional().stream();
        quitOption = empty.min(String::compareToIgnoreCase);
        System.out.println(quitOption.orElse("Nothing match here."));
        empty = new StreamOptional().stream();
        quitOption = empty.reduce((s1, s2) -> s1 + s2);
        System.out.println(quitOption.orElse("Nothing match here."));
        System.out.println(IntStream.empty().average().orElse(0));

        Stream<Integer> ints = IntStream.empty().boxed();
        Optional<Integer> optional = ints.findFirst();
        // optional.isPresent() 判断结果是否存在
        if (optional.isPresent()){
            // optional.get() 取出元素
            System.out.println(optional.get());
        } else {
            // 结果存在则返回结果，不存在则执行另外的操作
            System.out.println(optional.orElse(-1));
            // 结果存在则返回结果，不存在返回另外的对象
            System.out.println(optional.orElseGet(() -> -1));
            try {
                // 结果存在返回结果，不存在抛出自定义的异常
                System.out.println(optional.orElseThrow(() -> new Exception("null number")));
            }catch (Exception e){
                System.out.println("caught " + e);
            }
        }
        // 创建 Optional 对象的几种方式
        creatingOptionals("empty",Optional.empty()); // 创建一个空的 Optional 对象
        creatingOptionals("of",Optional.of("anger")); // 根据具体的值创建 Optional 对象
        /*
        在不明确值是否存在的时候使用该方法
        如果值为空，则调用 Optional.empty() 方法
         */
        creatingOptionals("ofNullable",Optional.ofNullable("Hi"));
        creatingOptionals("ofNullable",Optional.ofNullable(null));
    }
}
