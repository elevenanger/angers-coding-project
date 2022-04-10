package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/9 14:08
 * @description : 辛辣程度枚举
 */
public enum Spiciness {
    /*
    枚举类型的实例都是常量
    它们的名称都是大写的
     */
    NOT, MILD, MEDIUM, HOT, FLAMING;



    public static void main(String[] args) {
        /*
        使用枚举类
        创建对于其类型的引用
        将引用复制给枚举类的实例
         */
        Spiciness flaming = Spiciness.FLAMING;
        System.out.println(flaming.toString());
        // ordinal() 该枚举在枚举类中定义的顺序
        System.out.println(flaming.ordinal());
    }
}

