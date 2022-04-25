package com.angers.project.onjava8.stream.terminaloperation;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/4/24 18:25
 * @description : 流-终止操作-产生map
 */
public class MapCollector {
    public static void main(String[] args) {
        Map<Character,Integer> map =
                new RandomPair()
                        .pairStream()
                        .limit(8)
                        .collect(Collectors.toMap(Pair::getC,Pair::getI));
        System.out.println(map);
    }
}

class  Pair {
    final Character c;
    final Integer i;

    public Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", i=" + i +
                '}';
    }
}

class RandomPair {
    Random random = new Random(93);
    Iterator<Character> cs =
            random.ints(10,50)
                    .mapToObj(i -> (char)i)
                    .iterator();
    public Stream<Pair> pairStream(){
        return random.ints(60,100)
                .distinct()
                .mapToObj(i -> new Pair(cs.next(),i));
    }
}