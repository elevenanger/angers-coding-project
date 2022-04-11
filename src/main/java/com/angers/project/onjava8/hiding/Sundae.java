package com.angers.project.onjava8.hiding;

import java.time.LocalDateTime;

/**
 * @author : liuanglin
 * @date : 2022/4/10 16:41
 * @description : 圣代
 */
public class Sundae {

    /**
     * 使用 private 修饰方法
     * 您确定的任何方法只是该类的“辅助”方法
     * 以确保不会在包的其他地方意外使用它，从而禁止更改或删除该方法，将方法设为私有
     * 这个规则对于实例域也同样适用
     */
    private Sundae(){
        System.out.println(LocalDateTime.now() + " this new sundae is for sale.");
    }

    static Sundae makeASundae(){
        return new Sundae();
    }

    public static void main(String[] args) {
        // private 修饰的方法或者域，它所属的类拥有访问权限
        Sundae sundae = new Sundae();
        makeASundae();
    }
}
