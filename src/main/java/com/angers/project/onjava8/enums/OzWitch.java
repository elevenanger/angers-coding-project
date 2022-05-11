package com.angers.project.onjava8.enums;


import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/5/10 14:34
 * @description : 枚举-在枚举中添加方法
 */
public enum OzWitch {
    // 在方法之前，最先定义枚举值实例
    WEST("Miss Gulch"),
    NORTH("Glinda"),
    EAST("Wicked Witch"),
    // 如果需要在枚举类中定义方法，枚举值序列需要以 ; 结束
    SOUTH("Missing");

    private String desc;

    OzWitch(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 重写枚举方法
     * 和重写通常类的方法一样的形式重写枚举方法
     * @return 首字母大写，其余小写的枚举名
     */
    @Override
    public String toString() {
        String name = name();
        String lower  = name.substring(1).toLowerCase();
        return name.charAt(0) + lower;
    }

    /**
     * 枚举值可以配合 switch 语句使用
     * switch 语句只能够使用整数类型
     * 枚举类的 ordinal() 方法可以返回各个枚举类型的整数索引
     * 所以 switch 可以与枚举类一起使用
     * @param witch 巫师
     */
    public static void switchWitch(OzWitch witch){
        switch (witch) {
            case EAST:
                System.out.println(witch.toString() + " Dragon " + witch.getDesc());
                break;
            case WEST:
                System.out.println(witch.toString() + " Fire " + witch.getDesc());
                break;
            case SOUTH:
                System.out.println(witch.toString() + " Stone " + witch.getDesc());
                break;
            case NORTH:
                System.out.println(witch.toString() + " Snow " + witch.getDesc());
                break;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(OzWitch.values())
                .map(ozWitch -> ozWitch.toString() + " : " + ozWitch.getDesc())
                .forEach(System.out::println);

        Arrays.stream(OzWitch.values())
                .forEach(OzWitch::switchWitch);
    }
}