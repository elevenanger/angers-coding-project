package com.angers.project.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class StreamReduce {

    public static void main(String [] args){

        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(20);
        /*
        reduce 方法是从 stream 中求职的一种通用的方式
        最简单的形式是使用一个二元函数，并持续应用它
        从最初的两个元素开始
        下面这个例子，reduce 中的函数运算 v0 + v1+ v2 + ...
        vi 是 stream 中的元素
        返回 Optional 是因为当 stream 可能为空时没有有效的结果
         */
        Optional <Integer> sum = values.stream().reduce((x,y)->x+y);
        log.info(sum.toString());
        // 上面的求和可以重写为这种形式
        sum = values.stream().reduce(Integer::sum);
        log.info(sum.toString());

        /*
        使用一个恒等式参与最初的运算
        0 + v0 + v1+ v2 + ...
        当 stream 为空时，返回 0
        不需要再使用 Optional 类
         */
        Integer sum1 = values.stream().reduce(0,Integer::sum);
        log.info(Integer.toString(sum1));
    }
}
