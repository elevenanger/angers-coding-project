package com.angers.project.onjava8.innerclasses.controller;

import java.time.Duration;
import java.time.Instant;

/**
 * @author : liuanglin
 * @date : 2022/4/16 15:41
 * @description : 内部类-事件
 * 事件驱动系统设计
 */
public abstract class Event {
    // 事件时间
    private Instant evenTime;
    // 延迟时间
    protected Duration delayTime;

    /**
     * 构造事件对象
     * @param millSecondDelay 延迟时间
     */
    public Event(Long millSecondDelay) {
        // 初始化延迟时间为传入的数值
        delayTime = Duration.ofMillis(millSecondDelay);
        // 初始化事件时间
        start();
    }

    /**
     * 独立的方法对事件时间进行设置
     * 事件时间设置为当前时间线加上延迟时间
     * 可以在时间结束后调用该方法重置时间
     * 然后重新使用事件对象
     */
    public void start(){
        evenTime = Instant.now().plus(delayTime);
    }

    /**
     * 检查事件是否就绪
     * @return true 就绪 false 未就绪
     * 该方法也可以被重写，根据实际的使用场景添加检查条件
     */
    public boolean ready(){
        return Instant.now().isAfter(evenTime);
    }

    /**
     * 时间就绪执行的操作
     * 抽象方法
     * 交给继承的类根据具体需求去实现该方法
     */
    public abstract void action();
}
