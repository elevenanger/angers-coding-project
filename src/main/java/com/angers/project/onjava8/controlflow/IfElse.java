package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 08:40
 * @description : if - else 逻辑控制语句
 */
public class IfElse {

    static int result = 0;

    static void test (int v1,int v2){
        if (v1>v2)
            result = 1;
        else if (v1 < v2) // else if 不是关键字，只是 else 后面跟随一个新的 if 语句
            result = -1;
        else
            result = 0;
    }

    public static void main(String[] args) {
        test(5,10);
        System.out.println(result);
        test(10,5);
        System.out.println(result);
        test(5,5);
        System.out.println(result);
    }
}
