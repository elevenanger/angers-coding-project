package com.angers.project.onjava8.interfaces.interfaceprocessor;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:16
 */
public class Applicator {
    public static void apply(Processor p,Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
