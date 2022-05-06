package com.angers.project.onjava8.reflection;

import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/5 14:43
 * @description :反射-定义机器人的操作
 */
public class Operation {
    // 行为的描述
    public final Supplier<String> desc;
    // 行为的指令
    public final Runnable cmd;

    public Operation(Supplier<String> desc, Runnable cmd) {
        this.desc = desc;
        this.cmd = cmd;
    }
}
