package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/5/25 08:43
 * @description : 战场-影响技能释放的因素
 */
public class BattleField {
    /**
     * 影响技能释放时间
     * 前摇时间增长
     */
    public void forward(){}

    /**
     * 影响技能释放时间
     * 后摇时间增长
     */
    public void backward(){}
}

class WaterField extends BattleField {
    @Override
    public void forward() {
        System.out.println(getClass().getSimpleName() + " take forward effect 0.3");
        new Nap(0.3);
    }

    @Override
    public void backward() {
        System.out.println(getClass().getSimpleName() + " take backward effect 0.4");
        new Nap(0.4);
    }
}