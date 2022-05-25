package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:46
 * @description :垃圾分类与回收项目
 * 垃圾基类
 */
public abstract class Trash {
    // 重量
    public final double weight;

    Trash(double weight) {
        this.weight = weight;
    }

    /*
    返回当前材料的售价
     */
    public abstract double price();

    public abstract void accept(Visitor v);

    @Override
    public String toString() {
        return String.format(
                "%s weight: %.2f price: %.2f = %.2f" ,
                getClass().getSimpleName(),
                weight,
                price(),
                weight * price());
    }
}
