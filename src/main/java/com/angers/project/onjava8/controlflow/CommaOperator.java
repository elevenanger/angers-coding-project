package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 09:14
 * @description : 逗号操作符，用来分隔定义和方法参数，可以运用于 for 循环的初始化和步长部分表达式
 * 可以在一个 for 循环语句中定义多个变量，但是它们的类型必须相同
 * ,分隔的表达式将会按照顺序进行运算
 * for (initialization ; boolean expression ; step)
 *     statement;
 */
public class CommaOperator {

    public static void main(String[] args) {
        for (int i = 1, j = 10 ; i < 10 ; i++ , j += (i * 2)){
            System.out.println(" i = " + i + " , j = " + j);
        }
    }
}
