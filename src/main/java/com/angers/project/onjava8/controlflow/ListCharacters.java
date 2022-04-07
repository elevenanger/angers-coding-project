package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 09:08
 * @description : 使用 for 循环语句进行计数
 */
public class ListCharacters {

    public static void main(String[] args) {
        for (char c = 0; c < 128 ; c++ ){
            if (Character.isLowerCase(c))
                System.out.println("Value: " + (int)c + " character " +c);
        }
    }
}
