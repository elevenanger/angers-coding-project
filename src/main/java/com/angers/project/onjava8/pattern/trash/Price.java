package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:51
 * @description : 垃圾回收项目-售价类
 */
public interface Price {
    /*
    使用接口定义各种材料的售价
    在接口中所有的属性都是 public static final 的
     */
    double ALUMINUM = 1.67;
    double PAPER = 0.10;
    double GLASS = 0.23;
    double CARDBOARD = 0.11;
}
