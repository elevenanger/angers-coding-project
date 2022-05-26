package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/26 08:08
 * @description :可添加 Trash
 */
public interface Fillable <T extends Trash>{
    void addTrash(T trash);
}
