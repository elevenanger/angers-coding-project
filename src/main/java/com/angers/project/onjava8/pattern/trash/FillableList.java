package com.angers.project.onjava8.pattern.trash;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/26 08:20
 * @description : 将 Trash 对象添加到 List 中
 */
public class FillableList<T extends Trash> implements Fillable<T>{
    private List<T> list;

    public FillableList(List<T> list) {
        this.list = list;
    }

    @Override
    public void addTrash(T trash) {
        list.add(trash);
    }
}
