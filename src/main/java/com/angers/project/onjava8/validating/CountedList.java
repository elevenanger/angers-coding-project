package com.angers.project.onjava8.validating;

import java.util.ArrayList;

/**
 * @author : liuanglin
 * @date : 2022/4/26 08:26
 * @description : 验证-继承 ArrayList 的数组，统计已创建的对象
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CountedList() {
        System.out.println("CountedList # " + id);
    }

    public int getId() {
        return id;
    }

}
