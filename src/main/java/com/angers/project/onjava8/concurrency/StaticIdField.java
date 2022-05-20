package com.angers.project.onjava8.concurrency;

/**
 * @author : liuanglin
 * @date : 2022/5/19 08:13
 * @description : 并发-使用 static 域追踪 id 值
 */
public class StaticIdField implements HasId{
    // 使用 static 域进行计数
    private static int counter = 0;
    // 每次创建新对象 id ++
    private int id = counter ++ ;

    @Override
    public int getId() {
        return id;
    }
}
