package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/2 14:49
 * @description :
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;
    LinkedList<MapEntry<K,V>> [] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K,V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket == null) continue;
            for (MapEntry<K,V> mPair : bucket)
                set.add(mPair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(10));
        m.forEach((k,v) -> System.out.println(k + " = " + v));
        System.out.println(m.get("BENIN"));
        m.entrySet().forEach(System.out::println);
    }
}
