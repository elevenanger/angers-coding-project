package com.angers.project.onjava8.enums;
import com.angers.project.onjava8.housekeeping.Spiciness;

import static com.angers.project.onjava8.housekeeping.Spiciness.*;

/**
 * @author : liuanglin
 * @date : 2022/5/10 14:30
 * @description :static 引入枚举类
 * static 引入枚举类将枚举类中的所有实例域标识引入到本地
 */
public class Burrito2 {
    Spiciness spiciness;

    public Burrito2(Spiciness spiciness) {
        this.spiciness = spiciness;
    }

    @Override
    public String toString() {
        return "Burrito2{" +
                "spiciness=" + spiciness +
                '}';
    }

    public static void main(String[] args) {
        // 可以直接使用枚举
        System.out.println(new Burrito2(FLAMING));
        System.out.println(new Burrito2(MEDIUM));
    }
}
