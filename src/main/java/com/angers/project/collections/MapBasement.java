package com.angers.project.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/*
set 可以快速查找一个已知的元素，但是查找一个元素，需要使用这个元素的副本，这种情况并不常见
一般情况下，我们会有一些元素的信息，并借此来查找对应的元素
map 结构数据解决了这个问题
map 中的每个元素都由键值对组成
通过 key 即可查找到对应的键值对
 */
@Slf4j
public class MapBasement {

    public static void main (String [] args){
        /*
        hashmap 对 key 做 hash 处理
         */
        HashMap<String,String> stringHashMap = new HashMap<>();
        /*
        treemap 使用 key 类型的排序规则对key进行排序
        无论是 hashmap 的 hash 还是 treemap 的排序都只作用于 key
        与集合一样，如果 hashmap 的速度更快，如果不需要对 key 进行排序一般选择 hashmap 即可
         */
        TreeMap<String,String> stringTreeMap = new TreeMap<>();
        stringHashMap.put("1Hash","hash.1");
        stringHashMap.put("3Hash","hash.3");
        stringHashMap.put("2Hash","hash.2");
        stringTreeMap.put("1Tree","tree.1");
        stringTreeMap.put("3Tree","tree.3");
        stringTreeMap.put("2Tree","tree.2");
        // 使用 forEach 方法对 map 进行迭代
        stringHashMap.forEach((key,value)-> log.info("HashMap Key:"+key+"; value:"+value));
        stringTreeMap.forEach((key,value)-> log.info("TreeMap Key:"+key+"; value:"+value));
        // put 一个已存在的 key ，将会用新的 value 覆盖旧的值，并返回被覆盖的 value
        log.info(stringHashMap.put("3Hash","hash.new"));
        log.info(stringHashMap.get("3Hash"));
        // remove ，通过 key 删除元素 ，返回被删除元素的 value
        log.info(stringHashMap.remove("3Hash"));
        log.info(stringHashMap.toString());
        // 如果不确定一个 key 是否存在，并不想覆盖之前的 value ，使用 putIfAbsent 方法
        stringHashMap.putIfAbsent("1Hash","hash.1.new");
        log.info(stringHashMap.get("1Hash"));
        /*
         keySet() 是 map 中所有 key 的集合
         如果在 keySet 的迭代器中调用了 remove() 方法
         实际是移除了 map 中这个 key 对应的元素（键值对）
         不能在迭代器迭代的过程中使用 add() 方法
         entrySet 也有同样的限制
         */
        Iterator<String> keySet = stringHashMap.keySet().iterator();
        keySet.forEachRemaining(log::info);
        // values() 是 map 中 所有 value 的集合
        Iterator<String> values = stringHashMap.values().iterator();
        values.forEachRemaining(log::info);
        // entrySet() 是 map 中所有键值对的集合
        Iterator<Map.Entry<String,String>> entrySet = stringHashMap.entrySet().iterator();
        entrySet.forEachRemaining(entry->log.info(entry.toString()));

        /*
        LinkedHashMap 和 LinkedHashSet 会记住插入元素的顺序
        对元素进行访问或者修改时，会将修改的元素放置到集合的最末尾
         */
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1Link","A link");
        linkedHashMap.put("3Link","C link");
        linkedHashMap.put("2Link","B link");
        linkedHashMap.forEach((k,v)->log.info("LinkedHashMap key:"+k+" value:"+v));
        Iterator<String> linkKeys = linkedHashMap.keySet().iterator();
        linkKeys.forEachRemaining(log::info);
        Iterator<String> linkValues = linkedHashMap.values().iterator();
        linkValues.forEachRemaining(log::info);
        linkedHashMap.put("1Link","1.link.new");
        log.info(linkedHashMap.get("3Link"));

    }
}
