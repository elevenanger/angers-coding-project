package com.angers.project.onjava8.pattern.battle;

import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/23 17:21
 * @description : 游戏元素工厂类
 * 抽象工厂模式
 * 定义多个抽象工厂方法
 * 每个工厂方法生成某一种类对象
 * 首先定义一个抽象的工厂类
 * 包括可以创建的对象种类
 */
public class GameElementFactory {
    Supplier<Hero> heroSupplier;
    Supplier<Skill> skillSupplier;

    public Supplier<Skill> getSkillSupplier() {
        return skillSupplier;
    }

    public Supplier<Hero> getHeroSupplier() {
        return heroSupplier;
    }

    public void setSkillSupplier(Supplier<Skill> skillSupplier) {
        this.skillSupplier = skillSupplier;
    }

}

/*
定义具体的工厂类
继承抽象工厂类
定义具体的对象类型和创建方法
 */
class UltimateSkillHeroFactory extends GameElementFactory {
    public UltimateSkillHeroFactory() {
        heroSupplier = Hero::new;
        skillSupplier = UltimateSkill::new;
    }
}

class NormalSkillFactory extends GameElementFactory {
    public NormalSkillFactory() {
        skillSupplier = NormalSkill::new;
    }
}
class AbstractFactoryDemo {
    public static void main(String[] args) {
        GameElementFactory factory1 = new NormalSkillFactory();
        GameElementFactory factory2 = new UltimateSkillHeroFactory();
        Hero hero = factory2.getHeroSupplier().get();
        Skill skill1 = factory2.getSkillSupplier().get();
        Skill skill2 = factory1.getSkillSupplier().get();
        hero.setUltimateSkill((UltimateSkill) skill1);
        hero.setNormalSkills((NormalSkill) skill2);
        BaseCombo baseCombo = new BaseCombo(hero);
        baseCombo.combo();
    }
}