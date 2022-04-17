package com.angers.project.onjava8.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/4/16 15:56
 * @description : 内部类-事件-控制器 管理事件
 */
public class Controller {
    // 事件列表
    private List<Event> eventList = new ArrayList<>();

    /**
     * 往事件列表添加事件
     * @param event 事件
     */
    public void addEvent(Event event){
        eventList.add(event);
    }

    /**
     * 只要事件列表中存在事件
     * 则遍历事件列表
     * 寻找就绪的事件
     * 执行事件的 start 方法
     * 执行完毕之后从事件列表移除事件
     * 在这个控制类中，你并不知道事件是做什么的
     * 这就是设计的关键点
     * 分离变化的事物和不变的事物
     */
    public void run(){
        while(!eventList.isEmpty()){
            /*
            不覆盖原来的 eventList 拷贝原来的 list 使用一个新的 list 来进行遍历操作
             */
            new  ArrayList<>(eventList).stream()
                    .filter(Event::ready)
                    .forEach( event -> {
                        System.out.println(event);
                        event.action();
                        eventList.remove(event);
            });
        }
    }
}
