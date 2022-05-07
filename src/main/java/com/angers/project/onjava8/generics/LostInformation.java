package com.angers.project.onjava8.generics;


import java.util.*;

/**
 * @author : liuanglin
 * @date : 2022/5/6 15:33
 */
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob,Fnorkle> map = new HashMap<>();
        Quark<Frob> quark = new Quark<>();
        Paticle<Long,Double> particle = new Paticle<>();
        System.out.println(Arrays.toString(
                list.getClass().getTypeParameters()
        ));
        System.out.println(
                Arrays.toString(
                        map.getClass().getTypeParameters()
                )
        );
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
        /* output:
        [E]
        [K, V]
        [Q]
        [POSITION, MOMENTUM]

        泛型代码中没有泛型参数类型的信息
         */
    }
}

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Paticle<POSITION,MOMENTUM>{}