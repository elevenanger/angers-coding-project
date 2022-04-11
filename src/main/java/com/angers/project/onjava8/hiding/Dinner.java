package com.angers.project.onjava8.hiding;

import com.angers.project.onjava8.hiding.dessert.Cookie;

/**
 * @author : liuanglin
 * @date : 2022/4/10 16:24
 */
public class Dinner {

    public static void main(String[] args) {
        /*
        可以创建 Cookie 对象
        因为 Cookie 类和构造函数 Cookie() 都是 public
        但是由于 Dinner  和 Cookie 不在同一个包空间下
        bite() 方法没有修饰符修饰，默认只有 package 访问权限
        无权限访问 Cookie.bite() 方法
         */
        Cookie cookie = new Cookie();
        // cookie.bite();

        /* output:
        This is a Cookie !
         */
    }
}
