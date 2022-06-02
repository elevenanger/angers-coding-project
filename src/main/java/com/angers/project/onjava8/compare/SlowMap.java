package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/2 14:02
 * @description :
 */
public class SlowMap <K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    @Override
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set= new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext())
            set.add(new MapEntry<>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m = new SlowMap<>();
        m.putAll(Countries.capitals());
        m.forEach((k,v)-> System.out.println(k + " = " + v));
        System.out.println(m.get("BEIJING"));
        m.entrySet().forEach(System.out::println);
    }
}
