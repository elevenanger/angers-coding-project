package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/20 14:53
 * @description : 函数-多个参数的 Unbound 方法
 */
public class MultiArgumentsUnbound {
    public static void main(String[] args) {
        This t = new This();
        TwoArgs twoArgs = This::two;
        twoArgs.callTwo(t,1,2.0d);
        ThreeArgs threeArgs = This::three;
        threeArgs.callThree(t,1,2," ");
    }
}

class This {
    void two(int i,double d){
        System.out.println("This::two");
    }

    void three(int i,double d,String s){
        System.out.println("This::three");
    }
}

interface TwoArgs {
    void callTwo(This a,int i,double d);
}

interface ThreeArgs {
    void callThree(This a,int i,double d,String s);
}