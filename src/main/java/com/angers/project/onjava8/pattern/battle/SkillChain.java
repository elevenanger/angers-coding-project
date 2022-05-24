package com.angers.project.onjava8.pattern.battle;

import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/24 14:17
 * @description : 设计模式-责任链模式
 */
class SkillResult{
    public final boolean success;
    public final Skill skill;

    public SkillResult(Skill skill) {
        this.success = true;
        this.skill = skill;
    }
    private SkillResult(){
        success = false;
        skill = new Skill();
    }
    public static final SkillResult fail = new SkillResult();
}

/**
 * 技能附加效果接口
 */
interface SkillAddition {
    /**
     * 技能附加效果触发情况
     * @param skill 技能
     * @return 技能附加效果触发结果
     */
    SkillResult applyAddition(Skill skill);
}

/**
 * 技能附加效果责任链
 */
public class SkillChain {
    /**
     * 技能附加实现方法
     * 符合 SkillAddition 接口 applyAddition() 方法签名
     * @param skill 技能
     * @return 技能附加结果
     */
    public static SkillResult waterAddition(Skill skill){
        SkillResult skillResult = new SkillResult(skill);
        if (skill.getSkillName().contains("water")){
            skill.setDamage(skill.getDamage() * 2);
            skill.setSkillName("WA " + skill.getSkillName());
        }
        return skillResult;
    }
    public static SkillResult fireAddition(Skill skill){
        SkillResult skillResult = new SkillResult(skill);
        if (skill.getSkillName().contains("fire")){
            skill.setDamage(skill.getDamage() * 2);
            skill.setSkillName("FA " + skill.getSkillName());
        }
        return skillResult;
    }
    public static SkillResult failAddition(Skill skill){
        SkillResult skillResult = new SkillResult(skill);
        if (skill.getSkillName().contains("dark")){
            skill.setDamage(skill.getDamage() * 2);
            skill.setSkillName("XA " + skill.getSkillName());
            return SkillResult.fail;
        }
        return skillResult;
    }

    /**
     * 方法即对象
     * 将技能附加方法作为函数对象
     * 初始化技能附加函数列表
     */
    static List<SkillAddition> additions = Arrays.asList(
            SkillChain::fireAddition,
            SkillChain::waterAddition,
            SkillChain::failAddition
    );

    /**
     * 技能附加责任链处理
     * 将函数列表作为责任链
     * 传入技能，经过责任链处理后返回最终处理结果
     * @param skill 技能
     * @return 技能附加结果
     */
    public static SkillResult additionChain(Skill skill){
        SkillResult result = new SkillResult(skill);
        for (SkillAddition addition:additions) {
            result = addition.applyAddition(skill);
        }
        return result;
    }

    public static void main(String[] args) {
        SkillTypeFactory factory = new SkillTypeFactory();
        Skill skill1 = factory.create("UltimateSkill");
        skill1.setSkillName("fire water song");
        skill1.setDamage(220);
        SkillResult result = SkillChain.additionChain(skill1);
        if (result.success) result.skill.cast();
        else System.out.println("Nothing Happens");
        Skill skill2 = factory.create("NormalSkill");
        skill2.setSkillName("dark shot");
        skill2.setDamage(100);
        result = SkillChain.additionChain(skill2);
        if (result.success) result.skill.cast();
        else System.out.println("Nothing Happens");
        skill2.cast();
    }
}