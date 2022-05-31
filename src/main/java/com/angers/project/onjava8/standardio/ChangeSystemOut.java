package com.angers.project.onjava8.standardio;

import java.io.PrintWriter;

/**
 * @author : liuanglin
 * @date : 2022/5/31 17:18
 * @description :
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        /*
        System.out 是一个 PrintStream
        PrintStream 是 OutputStream 的一种
        OutputStream 可以作为 PrintWriter 构造函数的参数
        可以将 System.out 转换为 PrintWriter
         */
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("hello friend");
    }
}
