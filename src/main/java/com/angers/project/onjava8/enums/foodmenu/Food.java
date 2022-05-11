package com.angers.project.onjava8.enums.foodmenu;

/**
 * @author : liuanglin
 * @date : 2022/5/10 16:19
 * @description :枚举-使用接口实现枚举类的"继承关系"
 * 定义标记接口
 * 枚举类实现该接口
 */
public interface Food {
    enum ChineseFood implements Food {
            TOFU,EGG_FRIED_RICE,DUMPLING
    }
    enum WesternFood implements Food {
        STEAK,SANDWICH,HAMBURG
    }
    enum Soap implements Food {
        BORSCH,SEA_FOOD_SOAP,PUMPKIN_SOAP
    }
}
