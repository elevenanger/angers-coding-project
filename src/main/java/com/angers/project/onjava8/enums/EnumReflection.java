package com.angers.project.onjava8.enums;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/10 15:14
 * @description : 枚举-使用反射分析枚举类
 */
public class EnumReflection {
    public static Set<String> analyze(Class<?> enumCLass){
        CommonUtils.printDivide("Analyzing " + enumCLass.getSimpleName());
        CommonUtils.printDivide("Interfaces");
        Arrays.stream(enumCLass.getGenericInterfaces())
                .forEach(System.out::println);
        CommonUtils.printDivide("Base class");
        System.out.println(enumCLass.getSuperclass());
        CommonUtils.printDivide("Methods");
        return Arrays.stream(enumCLass.getMethods())
                .map(method -> method.toString())
                .peek(System.out::println)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Set<String> ex = analyze(Explore.class);
        Set<String> en = analyze(Enum.class);
        System.out.println("Explore contains all Enum methods ? " + ex.containsAll(en));
        ex.removeAll(en);
        System.out.println("Explore remove all Enum methods");
        ex.forEach(System.out::println);
        /*
        public static com.angers.project.onjava8.enums.Explore com.angers.project.onjava8.enums.Explore.valueOf(java.lang.String)
        public static com.angers.project.onjava8.enums.Explore[] com.angers.project.onjava8.enums.Explore.values()
        public static java.lang.Enum java.lang.Enum.valueOf(java.lang.Class,java.lang.String)
        values() 方法是编译增加的 static 方法
        valueOf() 方法在 Enum 类中也有定义
        但是 Enum 类中有两个参数
        Explore 中的 valueOf() 方法只有一个参数
         */
    }
}

enum Explore { HERE,THERE }