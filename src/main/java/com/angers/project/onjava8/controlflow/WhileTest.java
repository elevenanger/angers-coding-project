package com.angers.project.onjava8.controlflow;

/**
 * @author : liuanglin
 * @date : 2022/4/6 08:51
 * @description : 循环语句（迭代语句） - while 和 do - while
 */
public class WhileTest {

    static int value = 0;

    static boolean condition(){
        boolean result = value < 10;
        System.out.println(result + ",");
        return result;
    }

    public static void main(String[] args) {
        int i = 0;
        while (condition()){
            System.out.println("Inside while : ");
            value ++;
            i ++;
        }
        System.out.println("Exited while as " + i + " times.");

        value = 0;
        i = 0;

        /*
        do - while 和 while 的唯一区别
        do  - while 的语句至少会执行一次，即使条件从第一开始就是 false
        如果条件一开始就是 false ， while 语句直接就不执行
         */
        do{
            System.out.println("Inside do-while : ");
            value ++;
            i ++;
        }
        while (condition());
        System.out.println("Exited do-while as " + i + " times.");
    }
}
