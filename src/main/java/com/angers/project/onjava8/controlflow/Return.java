package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 09:54
 * @description : return 的两个意图：
 * 1、明确方法的返回值，如果为空则可以省略 return 语句
 * 2、返回该值，退出方法
 */
public class Return {
    static int test(int v1,int v2){
        if (v1>v2)
            return 1;
        else  if (v1 < v2)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(test(5,2));
        System.out.println(test(2,5));
        System.out.println(test(2,2));
    }
}
