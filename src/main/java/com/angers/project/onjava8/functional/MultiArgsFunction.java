package com.angers.project.onjava8.functional;

/**
 * @author : liuanglin
 * @date : 2022/4/21 09:44
 * @description : 函数-多参数函数接口
 */
public class MultiArgsFunction {
    static String getString(int i,char c,boolean b){
        return "" + i+ c + b;
    }
    public static void main(String[] args) {
        MultiArgs<Integer,Character,Boolean,String> multiArgs = MultiArgsFunction::getString;
        multiArgs = (i,c,b) -> "result";
    }
}

interface MultiArgs <T,U,V,R>{
    R accept(T t,U u,V v);
}
