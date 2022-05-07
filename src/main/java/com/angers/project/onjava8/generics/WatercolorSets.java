package com.angers.project.onjava8.generics;

import com.angers.project.onjava8.generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;
import static com.angers.project.onjava8.generics.watercolors.Watercolors.*;

/**
 * @author : liuanglin
 * @date : 2022/5/6 11:23
 * @description :
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED,VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE,BURNT_UMBER);
        System.out.println("set1 " + set1);
        System.out.println("set2 " + set2);
        System.out.println("union " + Sets.union(set1,set2));
        Set<Watercolors> subSet = Sets.intersection(set1,set2);
        System.out.println("intersection " + subSet);
        System.out.println(Sets.difference(set1,subSet));
        System.out.println(Sets.difference(set2,subSet));
        System.out.println("complement " + Sets.complement(set1,set2));
    }
}
