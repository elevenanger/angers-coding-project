package com.angers.project.onjava8.validating;

/**
 * @author : liuanglin
 * @date : 2022/4/26 14:37
 * @description :验证-用于处理 CircularQueue 的异常类
 */
public class CircularQueueException extends RuntimeException{
    public CircularQueueException(String msg) {
        super(msg);
    }
}
