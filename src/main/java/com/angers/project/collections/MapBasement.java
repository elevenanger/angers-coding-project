package com.angers.project.collections;

import java.util.HashMap;
import java.util.TreeMap;

/*
set 可以快速查找一个已知的元素，但是查找一个元素，需要使用这个元素的副本，这种情况并不常见
一般情况下，我们会有一些元素的信息，并借此来查找对应的元素
map 结构数据解决了这个问题
map 中的每个元素都由键值对组成
通过 key 即可查找到对应的键值对
 */
public class MapBasement {

    public static void main (String [] args){

        HashMap<String,String> stringHashMap = new HashMap<>();
        TreeMap<String,String> stringTreeMap = new TreeMap<>();
        stringTreeMap.put("first","anger");
    }
}
