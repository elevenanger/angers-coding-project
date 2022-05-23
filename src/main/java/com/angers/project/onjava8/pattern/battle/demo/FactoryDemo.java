package com.angers.project.onjava8.pattern.battle.demo;

import com.angers.project.onjava8.pattern.battle.*;

import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/23 09:17
 * @description : 工厂模式demo
 */
public class FactoryDemo {
    /**
     * 使用技能创建工厂创建技能
     * @param creator 技能创建器 实现 SkillFactoryCreator 接口 create() 方法
     */
    public static void testCreate(SkillFactoryCreator creator){
        Stream.of("NormalSkill","UltimateSkill","NormalSkill")
                .map(creator::create)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCreate(new SkillTypeFactory());
        testCreate(new SkillTypeDynamicFactory());

        /*
        将 Skill 的构造函数作为参数传入 RandomSkillFactory
        RandomSkillFactory 实现了 Supplier<Skill> 接口
        create 方法生成 Skill 对象
        增加新的 Skill 类型时
        这里是唯一需要修改的地方
         */
        RandomSkillFactory randomSkill = new RandomSkillFactory(
                NormalSkill::new,UltimateSkill::new
        );

        Stream.generate(randomSkill)
                .limit(5)
                .forEach(System.out::println);
    }
}