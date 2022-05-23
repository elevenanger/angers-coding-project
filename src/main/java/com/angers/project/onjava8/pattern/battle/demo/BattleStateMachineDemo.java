package com.angers.project.onjava8.pattern.battle.demo;

import com.angers.project.onjava8.pattern.battle.BaseCombo;
import com.angers.project.onjava8.pattern.battle.Hero;
import com.angers.project.onjava8.pattern.battle.NormalSkill;
import com.angers.project.onjava8.pattern.battle.UltimateSkill;

/**
 * @author : liuanglin
 * @date : 2022/5/23 09:00
 * @description : 设计模式-状态机demo
 */
public class BattleStateMachineDemo {
    public static void main(String[] args) {

        Hero fan = new Hero();
        NormalSkill stickPunch = new NormalSkill();
        stickPunch.setSkillName("烧火棍打击");
        stickPunch.setDamage(100);
        NormalSkill drinkBlood = new NormalSkill();
        drinkBlood.setSkillName("嗜血");
        drinkBlood.setDamage(120);
        UltimateSkill killGod = new UltimateSkill();
        killGod.setSkillName("诛仙");
        killGod.setDamage(500);
        fan.setNormalSkills(stickPunch,drinkBlood);
        fan.setUltimateSkill(killGod);

        new BaseCombo(fan);
    }
}
