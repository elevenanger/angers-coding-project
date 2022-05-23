package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.pattern.battle.exceptions.BadSkillCreationException;

/**
 * @author : liuanglin
 * @date : 2022/5/23 09:22
 * @description : 技能创建工厂类-通过技能类型创建技能
 */
public class SkillTypeFactory implements SkillFactoryCreator {
    @Override
    public Skill create(String skillType) {
        switch (skillType) {
            case "NormalSkill" : return new NormalSkill();
            case "UltimateSkill" : return new UltimateSkill();
            default:
                throw new BadSkillCreationException(skillType);
        }
    }
}
