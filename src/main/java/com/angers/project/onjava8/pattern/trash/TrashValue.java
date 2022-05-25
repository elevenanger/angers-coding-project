package com.angers.project.onjava8.pattern.trash;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/25 15:02
 * @description : 工具类
 * 接收一个垃圾列表
 * 展示每个部分
 * 计算总价格
 */
public class TrashValue {
    private static double total;

    /**
     * 计算一堆垃圾的总价格
     * @param trashes 垃圾堆
     * @param type 类型
     */
    public static void sum(List<? extends Trash> trashes,String type){
        total = 0.0;
        trashes.forEach(
                trash -> {
                    System.out.println(trash);
                    total += trash.weight * trash.price();});
        System.out.printf("Total %s value = %.2f%n",type,total);
    }
}
