package com.angers.project.onjava8.compare;

import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/6/2 15:34
 * @description :
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s2 : created)
            if (s2.equals(s))
                id ++ ;
    }

    @Override
    public String toString() {
        return "CountedString{" +
                "s='" + s + '\'' +
                ", id=" + id + '\'' +
                ",hashCode=" + hashCode() +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                Objects.equals(s,((CountedString) obj).s) &&
                Objects.equals(id,((CountedString) obj).id);
    }

    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<>();
        CountedString [] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i],i);
        }
        System.out.println(map);
        Arrays.stream(cs)
                .peek(System.out::println)
                .forEach(countedString -> System.out.println(map.get(countedString)));
    }
}
