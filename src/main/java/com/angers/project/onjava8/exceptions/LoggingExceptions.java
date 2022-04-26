package com.angers.project.onjava8.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author : liuanglin
 * @date : 2022/4/25 13:57
 * @description : 异常-使用日志记录异常
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw  new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught : " + e);
        }
        try {
            throw  new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught : " + e);
        }
    }
}

class LoggingException extends Exception {
    // 创建 Logger 对象
    private static Logger logger = Logger.getLogger("LoggingException");

    /**
     * 将日志记录的操作全部封装在异常内部
     * 触发了异常它会自动处理，不需要客户端的介入
     * 但是更通用的做法是捕捉并记录他人的异常
     * 使用异常处理器 （handler） 来生成日志信息
     */
    public LoggingException() {
        StringWriter writer = new StringWriter();
        printStackTrace(new PrintWriter(writer));
        // 输入日志内容，日志级别 severe
        logger.severe( writer.toString());
    }
}

class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggingException2");

    /**
     * 封装了对异常日志输出
     * 传入异常对象
     * 通过该异常处理器输出日志
     * @param e 异常
     */
    static void logException(Exception e){
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        logger.severe(writer.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e){
            LoggingExceptions2.logException(e);
        }
    }
}