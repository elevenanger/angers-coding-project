package com.angers.project.onjava8.pattern;

import com.angers.project.onjava8.Nap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/21 11:40
 * @description : 设计模式-状态机模式
 */

/*
施放技能接口
 */
interface CastSkill {
    /**
     * 施放技能方法
     */
    void cast();
}

/**
 * 技能连招
 * 按照特性顺序施放不同的技能
 * 每个技能都是一个状态
 * 技能施放顺序组成状态机
 */
abstract class SkillCombo {
    /**
     * 当前技能
     */
    protected CastSkill currentSkill;

    /**
     * 改变技能（改变状态）
     * 控制状态
     * @return 是否还有未施放的技能
     */
    protected abstract boolean changeSkill();

    /**
     * 状态机运作方法
     * 施放到最后一个技能
     * 按照状态机顺序执行整个过程
     */
    protected final void combo(){
        while(changeSkill()) currentSkill.cast();
    }
}

class Skill implements CastSkill{
    private String skillName;
    private int damage;
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
}

class NormalSkill extends Skill {
    @Override
    public void cast() {
        new Nap(0.3);
        System.out.println("Normal " + this.getSkillName() + " hit " + this.getDamage());
    }
}

class UltimateSkill extends Skill {
    @Override
    public void cast() {
        new Nap(0.8);
        System.out.println("Ultimate " + this.getSkillName() + " hit " + this.getDamage());
    }
}

class Hero {
    private List<NormalSkill> normalSkills;
    private UltimateSkill ultimateSkill;

    public List<NormalSkill> getNormalSkills() {
        return normalSkills;
    }

    public void setNormalSkills(List<NormalSkill> normalSkills) {
        this.normalSkills = normalSkills;
    }

    public UltimateSkill getUltimateSkill() {
        return ultimateSkill;
    }

    public void setUltimateSkill(UltimateSkill ultimateSkill) {
        this.ultimateSkill = ultimateSkill;
    }
}
class BaseCombo extends SkillCombo {
    private Iterator<Skill> skills;

    public BaseCombo(Hero hero) {
        makeBaseCombo(hero);
        combo();
    }

    void makeBaseCombo(Hero hero){
        int normalCount = hero.getNormalSkills().size();
        Skill [] skillsArray = new Skill[normalCount + 1];
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
public class StateMachineDemo {
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
        List<NormalSkill> normalSkills = new ArrayList<>();
        normalSkills.add(stickPunch);
        normalSkills.add(drinkBlood);
        fan.setNormalSkills(normalSkills);
        fan.setUltimateSkill(killGod);

        new BaseCombo(fan);
    }
}