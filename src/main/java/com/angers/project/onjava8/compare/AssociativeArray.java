package com.angers.project.onjava8.compare;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/6/4 16:18
 * @description : 关联数组- map 的原理
 */
public class AssociativeArray<K,V> {
    private Object [] [] pairs;
    private int index;

    /**
     * 关联数组构造函数
     * 二维数组
     * 一维是数组的长度
     * 第二个维度是键值对
     * @param length 数组的长度
     */
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    /**
     * 往数组中插入元素
     * @param key pairs 的 key
     * @param value pairs 的 value
     */
    public void put(K key,V value){
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        /*
        第一位是索引值
        没一个新的 键值对 的索引是现有元素索引 + 1
         */
        pairs[index ++ ] = new Object[] {key,value};
    }

    /**
     * 查找 key 对应的 value
     * @param key 查找的 key
     * @return 对应的value
     */
    @SuppressWarnings("unchecked")
    public V get(K key){
        for (Object[] pair : pairs)
            if (key.equals(pair[0]))
                return (V) pair[1];
        return null;
    }

    @Override
    public String toString() {
        StringBuilder pairString = new StringBuilder("{");
        for (Object [] pair : pairs){
            pairString
                    .append(pair[0])
                    .append(":")
                    .append(pair[1])
                    .append(",");
        }
        pairString.append("}");
        return "AssociativeArray{" +
                "pairs=" + pairString +
                ",index=" + index +
                '}';
    }

    public static void main(String[] args) {
        AssociativeArray<String,String> map = new AssociativeArray<>(4);
        map.put("wong","five");
        map.put("zhang","three");
        map.put("li","four");
        map.put("zhao","six");
        try {
            map.put("lao","eight");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Too many Objects");
        }
        System.out.println(map);
        System.out.println(map.get("zhang"));
    }
}
