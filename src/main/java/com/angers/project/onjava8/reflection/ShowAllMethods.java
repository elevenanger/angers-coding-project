package com.angers.project.onjava8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/4 12:05
 * @description :反射-使用反射的机制获取某个类可以使用的所有的方法
 */
public class ShowAllMethods {
    private static String usage =
            "作用 ： \n" +
                    "ShowAllMethods 根据类名 \n" +
                    "显示该类中所有的方法 \n" +
                    "或者根据输入的关键字 \n" +
                    "搜索含该关键字的方法 ";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method [] methods = c.getMethods();
            Constructor<?> [] constructors = c.getConstructors();
            if (args.length ==1 ) {
                Arrays.stream(methods)
                        .map(method -> p.matcher(method.toString()).replaceAll(""))
                        .forEach(System.out::println);
                Arrays.stream(constructors)
                        .map(constructor -> p.matcher(constructor.toString()).replaceAll(""))
                        .forEach(System.out::println);
                lines = methods.length + constructors.length;
            } else {
                lines += Arrays.stream(methods)
                        .filter(method -> method.toString().contains(args[1]))
                        .map(method -> p.matcher(method.toString()).replaceAll(""))
                        .peek(System.out::println)
                        .count();
                lines += Arrays.stream(constructors)
                        .filter(constructor -> constructor.toString().contains(args[1]))
                        .map(constructor -> p.matcher(constructor.toString()).replaceAll(""))
                        .peek(System.out::println)
                        .count();
            }
        }catch (ClassNotFoundException e){
            System.out.println("no such class " +e);
        }
        System.out.println(lines);
    }
}

class Test {
    public static void main(String[] args) {
        Class o = Object.class;
        String [] ob = {o.getCanonicalName(),"get"};
        ShowAllMethods.main(ob);
    }
}
