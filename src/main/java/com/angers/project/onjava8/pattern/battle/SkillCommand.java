package com.angers.project.onjava8.pattern.battle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/24 08:38
 * @description : 设计模式-命令模式
 */
public class SkillCommand {

    /**
     * 描述技能信息
     * 将 Skill 作为命令对象
     * 传递给命令方法
     * 根据不同的对象类型，表现不同的行为
     * @param skill 技能对象
     */
    public static void descSkill(Skill skill){
        String skillDesc =
                skill.getClass().getSimpleName() +
                " - " +
                skill.getSkillName() +
                " " +
                skill.getDamage() +
                " damage";
        System.out.println(skillDesc);
    }

    public static void main(String[] args) {
        SkillTypeDynamicFactory factory = new SkillTypeDynamicFactory();
        UltimateSkill ultimateSkill = (UltimateSkill) factory.create("UltimateSkill");
        ultimateSkill.setSkillName("Fire Rain");
        ultimateSkill.setDamage(200);
        NormalSkill normalSkill = (NormalSkill) factory.create("NormalSkill");
        normalSkill.setSkillName("Throw Stone");
        normalSkill.setDamage(100);

        descSkill(ultimateSkill);
        descSkill(normalSkill);

        List<CastSkill> castSkills = new ArrayList<>(
                Arrays.asList(ultimateSkill,normalSkill)
        );
        castSkills.forEach(CastSkill::cast);
    }
}