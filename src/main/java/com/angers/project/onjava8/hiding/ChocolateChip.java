package com.angers.project.onjava8.hiding;

import com.angers.project.onjava8.hiding.dessert.Cookie;

import java.time.LocalDateTime;

/**
 * @author : liuanglin
 * @date : 2022/4/10 17:08
 * @description : 继承 Cookie ，但是不在同一个 package
 */
public class ChocolateChip extends Cookie {

    public ChocolateChip(){
        System.out.println(LocalDateTime.now() + " this is a new Chocolate Chip .");
    }

    public static void main(String[] args) {
        ChocolateChip chocolateChip = new ChocolateChip();
        /*
        bite() 方法默认 package 访问权限
        ChocolateChip 和 Cookie 非同一个 package 所有没有该方法的访问权限
        normalBite() 方法被 protected 修饰
        所有继承 Cookie 的类都有权限访问该方法
         */
        // chocolateChip.bite();
        chocolateChip.normalBite();

        /* output:
        This is a Cookie !
        2022-04-10T17:18:48.999 this is a new Chocolate Chip .
        normal bite for Cookie family.
         */
    }
}
