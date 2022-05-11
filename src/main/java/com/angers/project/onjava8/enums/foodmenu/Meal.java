package com.angers.project.onjava8.enums.foodmenu;

import com.angers.project.onjava8.common.CommonUtils;

/**
 * @author : liuanglin
 * @date : 2022/5/10 17:13
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Menu menu : Menu.values()){
                Food food = menu.randomSelection();
                System.out.println(food);
            }
            CommonUtils.printDivide("foods");
        }
    }
}
