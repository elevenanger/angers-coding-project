package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/14 18:58
 * @description : 持有一系列的对象
 * 内部类对象包含一个对创建它的外部内对象隐式的连接
 * 通过这个连接，内部内对象可以获取外部类对象的成员变量
 * 内部类拥有外部类所有元素的访问权限
 */
public class Sequence {
    private Object [] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object o){
        if (next < items.length) items[next++] = o;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            // items 是外部类的 private 域，内部类具有访问权限
            return i==items.length;
        }

        @Override
        public void next() {
        if (i < items.length) i++;
        }

        @Override
        public Object current() {
            return items[i];
        }
    }
    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i <10 ; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }
}

interface Selector {
    boolean end();
    void next();
    Object current();
}