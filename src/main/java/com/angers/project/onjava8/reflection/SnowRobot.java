package com.angers.project.onjava8.reflection;

import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/5 14:57
 * @description :
 */
public class SnowRobot implements Robot{
    private String name;
    /*
    命令模式
    在具体实体类中定义需要执行的命令
    调用接口层面执行定义的命令
     */
    private List<Operation> operations = Arrays.asList(
            new Operation(
                    () -> name + " can fly",
                    () -> System.out.println(name + " can fly")
            ),
            new Operation(
                    () -> name + " frozen rays",
                    () -> System.out.println(name + " frozen rays")
            )
    );

    public SnowRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String model() {
        return "Snow Robot series 22";
    }

    @Override
    public List<Operation> operations() {
        return operations;
    }

    public static void main(String[] args) {
        Robot.test(new SnowRobot("Lion"));
    }
}
