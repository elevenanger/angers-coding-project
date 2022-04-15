package com.angers.project.onjava8.interfaces;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/14 09:31
 * @description : 接口-解耦
 * 策略设计模式
 */
public class Applicator {
    public static void apply(Processor p,Object s){
        /*
        apply 方法定义算法
        传入的对象是策略
        对象不同，策略不同，调用方法产生的行为和结果不同
         */
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        String s = "We are the world";
        apply(new Upcase(),s);
        apply(new Downcase(),s);
        apply(new Splitter(),s);
        /* output
        Using processor Upcase
        WE ARE THE WORLD
        Using processor Downcase
        we are the world
        Using processor Splitter
        [We, are, the, world]
         */
    }
}

class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    public Object process (Object input){
        return input;
    }
}

class Upcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
