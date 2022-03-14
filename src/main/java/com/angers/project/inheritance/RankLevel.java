package com.angers.project.inheritance;

import lombok.extern.slf4j.Slf4j;

/**
 * 等级枚举
 */
@Slf4j
public enum RankLevel {

    NORMAL("NM"),
    EXCELLENT("EC"),
    EXTRAORDINARY("EX");

    /**
     * 缩写
     */
    private final String abbreviation;

    /**
     * 等级枚举构造函数
     * 枚举类的构造函数是 private 的，代码可以省略 private
     * @param abbreviation 缩写
     */
    RankLevel(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public static void main(String [] args){
        RankLevel level = RankLevel.EXCELLENT;
        log.info(level.getAbbreviation());
    }

}
