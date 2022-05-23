package com.angers.project.onjava8.pattern.battle;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:47
 * @description : 技能基类
 */
public class Skill implements CastSkill{
    private static int counter = 0;
    private int id = counter ++;
    /*
    技能名称
     */
    private String skillName;

    /*
        技能伤害
         */
    private int damage;

    /**
     * 释放技能
     */
    @Override
    public void cast() {
        System.out.println(this.getSkillName()+ " hit " + this.getDamage());
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", damage=" + damage +
                '}';
    }
}