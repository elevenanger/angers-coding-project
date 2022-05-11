package com.angers.project.onjava8.enums;

import com.angers.project.onjava8.enums.foodmenu.Menu;

import java.util.EnumSet;

/**
 * @author : liuanglin
 * @date : 2022/5/10 17:25
 * @description :枚举-枚举集合
 */
public class EnumSets {
    public static void main(String[] args) {
        /*
        枚举集合的设计初衷是用来替代原始的位标识
        在枚举集合内部只有一个单一的 long 类型数值充当位向量，性能高效
        long 可以存储 64 位
        每一个枚举实例都需要有一位来表示其是否存在
         */
        EnumSet<Menu> foods =EnumSet.noneOf(Menu.class);
        // 添加元素
        foods.add(Menu.CHINESE_FOOD);
        System.out.println(foods);
        // 选择性批量添加元素
        foods.addAll(EnumSet.of(Menu.CHINESE_FOOD,Menu.SOAP,Menu.WESTERN_FOOD));
        System.out.println(foods);
        // 批量添加枚举类中的所有枚举类型
        foods = EnumSet.allOf(Menu.class);
        System.out.println(foods);
        // 批量删除元素
        foods.removeAll(EnumSet.of(Menu.CHINESE_FOOD,Menu.SOAP));
        System.out.println(foods);
        foods.addAll(EnumSet.of(Menu.CHINESE_FOOD,Menu.SOAP,Menu.WESTERN_FOOD));
        // 按索引范围删除元素
        foods.removeAll(EnumSet.range(Menu.CHINESE_FOOD,Menu.WESTERN_FOOD));
        System.out.println(foods);
        // 取枚举类型的补集
        foods = EnumSet.complementOf(foods);
        System.out.println(foods);
        /*
        EnumSet 可以存储超过 64 个实例域的枚举类型
        可以推测它是自适应的长度
        在必要时自增长一个 long 的长度
         */
        EnumSet<Over64> over64EnumSet = EnumSet.allOf(Over64.class);
        System.out.println(over64EnumSet);
    }
    enum Over64 {
        A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
        A11, A12, A13, A14, A15, A16, A17, A18, A19,
        A20, A21, A22, A23, A24, A25, A26, A27, A28,
        A29, A30, A31, A32, A33, A34, A35, A36, A37,
        A38, A39, A40, A41, A42, A43, A44, A45, A46,
        A47, A48, A49, A50, A51, A52, A53, A54, A55,
        A56, A57, A58, A59, A60, A61, A62, A63, A64,
        A65, A66, A67, A68, A69
    }
}
