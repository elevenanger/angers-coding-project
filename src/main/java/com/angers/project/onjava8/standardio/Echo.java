package com.angers.project.onjava8.standardio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : liuanglin
 * @date : 2022/5/31 17:13
 * @description : 使用标准输入
 */
public class Echo {
    public static void main(String[] args) {
        new BufferedReader(
                new InputStreamReader(System.in)
        ).lines().forEach(System.out::println);
    }
}
