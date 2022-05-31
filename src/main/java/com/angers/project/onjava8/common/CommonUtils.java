package com.angers.project.onjava8.common;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/9 11:18
 * @description : 工具类
 */
public class CommonUtils {

    public static final String DIVIDE_LINE = "------------------------------------------" ;

    public static final String DIVIDE_SIGNAL_BEGIN = ">>>";
    public static final String DIVIDE_SIGNAL_END = "<<<";

    public static final String FILE_PATH= "/Users/liuanglin/data/";

    public static final String IO_FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project/src/main/java/com/angers/project/onjava8/iostream/";

    public static final String NIO_FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project/src/main/java/com/angers/project/onjava8/newio/";

    /**
     * 对象拼接空格
     * @param s 参数
     * @return 拼接空格的字符串
     */
    public static String concatenateSpace(Object s){
        return s.toString().concat(" ");
    }

    /**
     * 打印分隔行
     */
    public static void printDivideLine(String ... args){
        System.out.println();
        Arrays.stream(args)
                .forEach(System.out::println);
        System.out.println(DIVIDE_LINE);
    }

    public static void printDivide(String msg){
        System.out.println(DIVIDE_SIGNAL_BEGIN + msg +DIVIDE_SIGNAL_END);
    }
    public static void printDivideLineStart(String desc){
        System.out.println(DIVIDE_LINE);
        System.out.println(desc + " start : ");
    }

    public static void printDivideLineEnd(String desc){
        System.out.println();
        System.out.println(desc + " end ! ");
        System.out.println(DIVIDE_LINE);
    }
}
