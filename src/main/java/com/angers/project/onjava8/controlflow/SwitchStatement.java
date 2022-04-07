package com.angers.project.onjava8.controlflow;

import java.awt.*;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/6 16:25
 * @description : switch 语句根据整型表达式的值执行对应的分支语句
 */
public class SwitchStatement {

    static void vowelsAndConsonants(){
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            System.out.println((char) c + ", " + c + " :");
            switch (c) {
                // 选择器只能使用整数类型值 ，比如 int ，char
                case 'a' :
                case 'e' :
                case 'i' :
                case 'o' :
                case 'u' :
                    /*
                    选择对应的分支代码执行
                    break 是可选项，如果没有 break ，代码将会按照顺序继续执行下一个 case ，直到遇到 break
                     */
                    System.out.println("元音字母。");
                    break;
                case 'y' :
                case 'w' :
                    System.out.println("部分情况下是元音字母。");
                    break;
                default: // 默认选项，如果无法匹配到选项，则执行该项
                    System.out.println("辅音字母。");
            }
        }
    }

    /**
     * Java 7 增加了 String 作为 switch 选择表达式的机制
     * @param color 颜色
     */
    static void stringSwitch(String color){
        switch (color) {
            case "red":
                System.out.println(Color.red);
                break;
            case "yellow" :
                System.out.println(Color.yellow);
                break;
            default:
                System.out.println("UNKNOWN");
        }
    }
    public static void main(String[] args) {
        vowelsAndConsonants();
        stringSwitch("red");
    }
}
