package com.angers.project.onjava8.pattern.battle;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:54
 * @description : 基础技能连招
 */
public class BaseCombo extends SkillCombo {
    private Iterator<Skill> skills;

    public BaseCombo(Hero hero) {
        makeBaseCombo(hero);
        combo();
    }
    void makeBaseCombo(Hero hero){
        int normalCount = hero.getNormalSkills().size();
        Skill[] skillsArray = new Skill[normalCount + 1];
        for (int i = 0; i < normalCount; i++) {
            skillsArray[i] = hero.getNormalSkills().get(i);
        }
        skillsArray[normalCount] = hero.getUltimateSkill();
        skills = Arrays.stream(skillsArray).iterator();
    }
    protected boolean changeSkill() {
        if (!skills.hasNext()) return false;
        currentSkill = skills.next();
        return true;
    }
}