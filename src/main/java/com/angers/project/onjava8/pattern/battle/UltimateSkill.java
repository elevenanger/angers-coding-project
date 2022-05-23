package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:51
 * @description : 终极技能
 */
public class UltimateSkill extends Skill{
    @Override
    public void cast() {
        new Nap(0.8);
        System.out.println("Ultimate " + this.getSkillName() + " hit " + this.getDamage());
    }
}
