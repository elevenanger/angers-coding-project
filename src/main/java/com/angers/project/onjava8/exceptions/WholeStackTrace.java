package com.angers.project.onjava8.exceptions;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/25 15:00
 * @description : 异常-stacktrace获取更多的异常信息
 */
public class WholeStackTrace {
    static void f(){
        try {
            throw new Exception("f()");
        }catch (Exception e){
            // getStackTrace() 方法获取 stack trace 元素数组，每一个元素都表示一帧 stack trace
            Arrays.stream(e.getStackTrace())
                    .map(StackTraceElement::getMethodName)
                    .forEach(System.out::println);
        }
    }
    static void g(){
        f();
    }
    static void  h() {
        g();
    }

public static void main(String[] args) {
        WholeStackTrace.h();
    }
}