package com.angers.project.onjava8.controlflow;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/6 09:24
 * @description : for - in 循环语句，比传统的 for 语句更加简介
 * 用于进行数组和集合的遍历等操作
 */
public class ForInLoop {

    static void forInString(String s){
        System.out.println("String " + s + " to char array : ");
        for (char c : s.toCharArray()){
            System.out.print(c + " ");
        }
    }

    public static void main(String[] args) {
        float [] floats = new float[10];
        Random random = new Random(93);
        for (int i = 0; i < 10; i++){
            floats [i] = random.nextFloat();
        }

        // 按顺序将 floats 数组中的每个元素赋值给 float 类型的 f
        for (float f : floats){
            System.out.println(f);
        }

        forInString("anger");
    }
}
