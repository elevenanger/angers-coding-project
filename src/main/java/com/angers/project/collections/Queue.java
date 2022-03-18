package com.angers.project.collections;

/**
 * 队列
 * 具备基本新增、删除元素以及计算队列长度的队列
 * @param <E> 队列中的元素
 */
public interface Queue <E>{
    /**
     * 添加元素
     * @param element 元素
     */
    void add(E element);

    /**
     * 移除元素
     * @return 被移除的元素
     */
    E remove();

    /**
     * 队列长度
     * @return 队列元素数
     */
    int size();

}