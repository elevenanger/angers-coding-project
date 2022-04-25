package com.angers.project.onjava8.stream.terminaloperation;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/4/24 18:19
 * @description : 流-使用 collect 方法将终止流输出 collection
 */
public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        TreeSet<String>treeSet = Files.lines(Paths.get(Paths.get(CommonUtils.FILE_PATH) + "/notice.txt"))
                .skip(10)
                .flatMap( s -> Arrays.stream(s.split("\\W+")))
                .filter(s -> s.length() > 10)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new)); // 将流转换成 TreeSet
        System.out.println(treeSet);
    }
}
