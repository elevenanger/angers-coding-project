package com.angers.project.onjava8.interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:19
 * @description :接口-字符串处理器
 */
public interface StringProcessor extends Processor {
    @Override
    String process(Object input);
    String STRING = "We are the world";

    static void main(String[] args) {
        Applicator.apply(new Upcase(),STRING);
        Applicator.apply(new Downcase(),STRING);
        Applicator.apply(new Splitter(),STRING);
        /* output:
        Using Processor Upcase
        WE ARE THE WORLD
        Using Processor Downcase
        we are the world
        Using Processor Splitter
        [We, are, the, world]
         */
    }
}

class Upcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase implements StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}