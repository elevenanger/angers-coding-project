package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.Null;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/5 14:41
 * @description :反射-机器人接口，定义机器人的基本信息和行为
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    /*
    测试机器人行为
    执行每个操作
     */
    static void test(Robot robot){
        if (robot instanceof Null)
            System.out.println("null robot");
        System.out.println("robot name : " + robot.name());
        System.out.println("robot model :" + robot.model());
        robot.operations().stream()
                .map(operation -> operation.cmd)
                .forEach(Runnable::run);
    }
}
