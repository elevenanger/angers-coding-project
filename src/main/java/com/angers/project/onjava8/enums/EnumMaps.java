package com.angers.project.onjava8.enums;


import java.util.EnumMap;

/**
 * @author : liuanglin
 * @date : 2022/5/11 08:46
 * @description :枚举-EnumMap
 */
interface Command {
    void action();
}
enum SunZiBingFa {
    DAO("道者，令民与上同意也，故可以与之死，可以与之生，而不畏危"),
    TIAN("天者，阴阳、寒暑、时制也"),
    DI("地者，远近、险易、广狭、死生也"),
    JIANG("将者，智、信、仁、勇、严也"),
    FA("法者，曲制、官道、主用也");
    private String desc;
    SunZiBingFa(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
public class EnumMaps {
    public static void main(String[] args) {
        /*
        EnumMap 是一种特殊的 Map
        它的 key 只能由单一的枚举类实例构成
        因为这种约束
        EnumMap 内部可以用数组来实现
        数组 index 为枚举的 ordinal 索引
        所以它的性能非常的好
        和 EnumSet 一样 EnumMap 中元素的顺序由枚举类中枚举类型定义的顺序(ordinal)决定

        命令设计模式
        首先创建一个只有单一方法的接口（命令）
        创建多个该接口和方法的实现函数或者方法
        安装命令对象
        调用命令对象中的命令方法，执行命令
         */
        EnumMap<SunZiBingFa,Command> sunZi1 = new EnumMap<>(SunZiBingFa.class);
        sunZi1.put(SunZiBingFa.DI,
                () -> System.out.println((SunZiBingFa.DI.getDesc())));
        sunZi1.get(SunZiBingFa.DI).action();
        for (SunZiBingFa bingFa: SunZiBingFa.values()) {
            sunZi1.put(bingFa,() -> System.out.println(bingFa.getDesc()));
        }
        sunZi1.forEach((key, value) -> {
            System.out.print(key + " : ");
            value.action();
        });
    }
}
