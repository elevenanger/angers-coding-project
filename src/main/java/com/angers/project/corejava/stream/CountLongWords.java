package com.angers.project.corejava.stream;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class CountLongWords {

    public static void main (String [] args){
        Path path = Paths.get("/Users/liuanglin/data/NOTICE.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            Iterator<String> allLine = lines.iterator();
            allLine.forEachRemaining(log::info);
            /*
            使用流，可以声明式的声明预期达成的目标，而不是命令式的写实现逻辑
            filter(line -> line.length()>50) 声明筛选长度超过 50 的行 ，该操作为中间操作 ，输出仍然是 stream
            count() 声明需要计数的结果 终止操作 返回值为 int

            stream 和 collection 都可以转换和检索数据，但是其区别如下：
            1、stream 不存储元素，它们可能存储于集合中，也可以按需生成
            2、stream 操作不会修改源数据
            3、stream 是懒加载的，按需执行

            stream 的工作流：
            1、创建一个 stream
            2、声明将初始流 stream 换为其它 stream 的中间操作，可以有多个转换操作
            3、使用一个终止操作以产出结果(具体的结果，不再是中间 stream )，这个操作会强制执行在此操作之前的所有操作
            4、操作执行完成，产出结果，该 stream 生命周期结束，无法再被使用
             */
            long count = lines.stream()
                    .filter(line -> line.length()>50)
                    /*
                    使用 map 对 stream 中的元素进行转换
                    map 中的函数作用于 stream 中的每一个元素
                     */
                    .map(String::toUpperCase)
                    .map(string -> string.substring(0,1))
                    .count();
            log.info(Long.toString(count));
            /*
            使用 parallelStream() 进行并行筛选和计数
             */
            long countInParallel = lines.parallelStream()
                    .filter(line -> line.length()>50)
                    .count();
            log.info(Long.toString(countInParallel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
