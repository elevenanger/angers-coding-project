package com.angers.project.onjava8.pattern.battle;

/**
 * @author : liuanglin
 * @date : 2022/5/23 09:13
 * @description : 技能创建接口
 */
public interface SkillFactoryCreator {
    /**
     * 通过技能类型创建技能
     * @param skillType 对应 NormalSkill 和 UltimateSkill
     * @return 技能
     */
    Skill create(String skillType);
}