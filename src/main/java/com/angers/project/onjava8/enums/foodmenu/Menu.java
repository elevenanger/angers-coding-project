package com.angers.project.onjava8.enums.foodmenu;

import com.angers.project.onjava8.enums.EnumsRandomSelection;

/**
 * @author : liuanglin
 * @date : 2022/5/10 16:32
 * @description : 枚举-在枚举中定义枚举
 */
public enum Menu {
    CHINESE_FOOD(Food.ChineseFood.class),
    WESTERN_FOOD(Food.WesternFood.class),
    SOAP(Food.Soap.class);

    private Food [] foods;

    private Menu(Class<? extends Food> kind){
        foods = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return EnumsRandomSelection.random(foods);
    }
}
