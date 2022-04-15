package com.angers.project.onjava8.interfaces.interfaceprocessor;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:15
 * @description : 接口-处理器
 */
public interface Processor {
    default String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input);
}
