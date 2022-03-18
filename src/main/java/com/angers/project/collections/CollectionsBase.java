package com.angers.project.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Iterator;

@Slf4j
public class CollectionsBase {

    /**
     * 遍历 String 集合
     * @param strings String 集合
     */
    public void collectionIterator(Collection<String> strings){
        /*
        实现了 Iterator 接口的对象
        可以使用其循环遍历集合中的每一个元素
         */
        Iterator<String> iterator = strings.iterator();
        // 判断集合中是否还有剩余的元素，亦即 next() 方法是返回一个元素还是抛出异常
        if (iterator.hasNext()){
            /*
            返回集合迭代的下一个元素
            如果已经没有更多的元素，会抛出 NoSuchElementException 异常
            所以调用该方法前，需要检查是否还有剩余的元素
             */
            log.info(iterator.next());
            /*
            删除刚刚经过 iterator.next() 迭代的元素，每次 next() 方法后，只能使用一次
             */
            iterator.remove();
        }
        /*
        调用 forEachRemaining 方法，使用 lambda 表达式对元素进行操作
         */
        iterator.forEachRemaining(log::info);
        /*
        使用 for each 循环遍历集合中的元素，代码更精简
        编译器会将 for each 循环转换成迭代器循环
        for each 循环可以作用于任何实现了 Iterable 接口的对象
         */
        for (String str : strings){
            log.info(str);
        }
    }

}
