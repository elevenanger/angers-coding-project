package com.angers.project.onjava8.interfaces;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/13 20:34
 * @description : 在接口中定义 static 方法
 * 接口中的 static 方法是操作该接口的通用工具
 */
public interface Operations {
    void execute();
    /*
    模板方法设计模式
     */
    static void runOps(Operations ... ops){
        Arrays.stream(ops).forEach(Operations::execute);
    }
    static void show(String msg){
        System.out.println(msg);
    }
}
