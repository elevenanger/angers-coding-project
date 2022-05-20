package com.angers.project.onjava8.pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/19 11:06
 * @description : 设计模式-资源接口
 */
public interface Resource <T>{
    // 获取资源实例
    T get();
    // 设置资源实例
    void set(T t);
}
