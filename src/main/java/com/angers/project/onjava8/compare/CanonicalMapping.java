package com.angers.project.onjava8.compare;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author : liuanglin
 * @date : 2022/6/4 19:50
 * @description : 演示 WeakHashMap
 */
class Element {
    private String ident;
    Element(String id){
        ident = id;
    }

    @Override
    public String toString() {
        return "Element{" +
                "ident='" + ident + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ident);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element &&
                Objects.equals(ident,((Element) obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Element.finalize " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 100_00;
        if(args.length > 0) size = Integer.parseInt(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i%3==0) keys[i] = k;
            map.put(k,v);
        }
        System.gc();
    }
}
