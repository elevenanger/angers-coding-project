package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:50
 * @description : 普通技能
 */
public class NormalSkill extends Skill{
    @Override
    public void cast() {
        new Nap(0.3);
        System.out.println("Normal " + this.getSkillName() + " hit " + this.getDamage());
    }
}
