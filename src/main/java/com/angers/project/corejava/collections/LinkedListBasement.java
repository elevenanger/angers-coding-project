package com.angers.project.corejava.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

@Slf4j
public class LinkedListBasement {

    public static void main(String [] args){
        /*
        链表是有序集合
         */
        LinkedList<String> strings = new LinkedList<>();
        // add() 方法将对象添加到集合的末尾
        strings.add("and");
        strings.add("clever");
        strings.add("some");
        Iterator<String> stringIterator = strings.iterator();
        log.info(stringIterator.next()); // 获取第一个元素
        log.info(stringIterator.next()); // 获取第二个元素
        stringIterator.remove(); // 移除迭代器最后访问的元素,上面访问到第二个元素，所以移除的是第二个元素
        log.info(strings.toString());

        LinkedList<String> words = new LinkedList<>();
        words.add("first");
        words.add("second");
        words.add("third");
        ListIterator<String> stringListIterator =  words.listIterator();
        stringListIterator.add("before"); // 开始迭代之前插入的元素将会被添加到列表第一个位置
        // 获取第一个元素, nextIndex() ，next() 返回元素的位置索引
        log.info("往后迭代："+stringListIterator.nextIndex()+stringListIterator.next());
        stringListIterator.add("insert"); // 在迭代的位置之前插入元素，使用这个方法可以在链表中间插入元素
        stringListIterator.add("insertAgain"); // 多次调用 add() 方法在迭代位置之前按照顺序依次添加到链表
        log.info("往后迭代："+stringListIterator.nextIndex()+stringListIterator.next());

        log.info("往前迭代：" + stringListIterator.previousIndex()+stringListIterator.previous()); // 迭代器往前迭代一位
        stringListIterator.add("previousPosition"); // 在迭代的位置之前插入元素

        log.info(words.toString());
        // 迭代链表，直到没有下一个元素
        while(stringListIterator.hasNext()){
            stringListIterator.next();
        }
        /*
        迭代结束之后插入的元素将会被添加到最末端的位置，在迭代器位置之前插入元素
        add() 方法是以迭代器位置为准的，在迭代的位置前插入元素
        remove() 是以迭代器的状态为准的，删除迭代器当前迭代的元素
         */
        stringListIterator.add("last");
        log.info(words.toString());

        /*
        ListIterator set 方法
        和 remove() 一样，都是以迭代器的状态为准的，替换迭代器当前迭代的元素
         */
        LinkedList<String> stringsForSet = new LinkedList<>();
        stringsForSet.add("oldFirst");
        stringsForSet.add("oldSecond");
        ListIterator<String> iteratorForSet = stringsForSet.listIterator();
        log.info(iteratorForSet.next());
        iteratorForSet.set("newFirst");
        log.info(stringsForSet.toString());
        while(iteratorForSet.hasNext()){
            iteratorForSet.next();
        }
        log.info(iteratorForSet.previous());
        iteratorForSet.set("newSecond");
        log.info(stringsForSet.toString());

        /*
        如果迭代器检测到集合自身或者另一个迭代器对集合进行了修改操作
        会抛出 ConcurrentModificationException 异常
        防止并发异常的原则：
        可以为一个集合创建任意多只读的迭代器
        只能为一个集合创建一个读写操作的迭代器，不能同时存在任意其它的迭代器
        迭代器并发修改检测原理：
        1、每个集合都有一个修改操作计数器，追踪 add、remove 等修改操作
        2、每个迭代器都会保留一个它自己对于集合所做的修改操作计数器
        3、每次方法调用，迭代器都会先比对操作计数
        4、如果不匹配则会抛出异常

        LinkedList 只会追踪对于集合结构进行修改的操作，比如 ： add remove
        set 操作不会被认为是一个结构修改操作
         */
        ListIterator<String> anotherIteratorForSet1 = stringsForSet.listIterator();
        ListIterator<String> anotherIteratorForSet2 = stringsForSet.listIterator();
        try{
            anotherIteratorForSet1.next();
            anotherIteratorForSet1.remove();
            anotherIteratorForSet2.next();
        } catch (ConcurrentModificationException e){
            log.info(e.toString());
        }

        /*
        LinkedList 的索引从0开始
        虽然 LinkedList 提供了 get 方法
        但是它并不支持快速随机读，读取第 n 个元素，需要从第一个元素开始读，一直到第 n 个元素
        如果 n > size()/2 , 则从最后一个元素往前读
        LinkedList 对象没有缓存位置信息， get 方法是非常低效的

        使用 LinkedList 是为了将在列表中间插入和删除元素的成本降到最低
        如果元素很少的场景下，使用 ArrayList 即可
        避免使用通过整数索引在 LinkedList 表示元素位置的方法
        需要在一个集合中进行随机读的场景，使用 ArrayList
         */
        log.info(stringsForSet.get(0));
    }
}
