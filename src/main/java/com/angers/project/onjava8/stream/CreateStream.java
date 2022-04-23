package com.angers.project.onjava8.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/22 14:04
 * @description : 流-创建流
 */
public class CreateStream {

    /*
    Collection.stream() 可以将 Collection 集合对象转换为 stream
     */
    static void collectionToStream(Collection<?> collection){
        collection
                .stream()
                .map(v -> v +" ")
                .forEach(System.out::print);
        System.out.println();
    }

    static void mapToStream(Map<?,?> map){
        System.out.println();
        map.entrySet()
                .stream()
                .map( entry -> entry.getKey() + " : " +entry.getValue() + " ")
                .forEach(System.out::print);
    }
    public static void main(String[] args) {
        // 使用 Stream.of() 将一系列的元素转换成流
        Stream.of("We","are","the","world.")
                .map(v -> v + " ")
                .forEach(System.out::print);
        System.out.println();
        Stream.of("this","book","cost",5,"yuan")
                .forEach(v -> System.out.print(v+" "));

        Collection<String> strings = new HashSet<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("collection");
        collectionToStream(strings);
        strings = new ArrayList<>(strings);
        collectionToStream(strings);

        Map<String,String> map = new HashMap<>();
        map.put("1","first");
        map.put("3","third");
        map.put("2","second");
        mapToStream(map);
        map = new TreeMap<>(map);
        mapToStream(map);
    }
}
