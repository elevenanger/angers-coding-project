package com.angers.project.corejava.exception;

import java.io.IOException;

/**
 * 自定义异常类
 */
public class FileFormatException extends IOException {

    /**
     * 无参构造函数
     */
    public FileFormatException(){}

    /**
     * 构造函数，调用超类方法
     * @param message 需要报出的错误信息
     */
    public FileFormatException(String message){
        super(message);
    }
}
