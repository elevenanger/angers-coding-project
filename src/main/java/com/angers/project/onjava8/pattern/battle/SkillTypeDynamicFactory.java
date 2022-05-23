package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.pattern.battle.exceptions.BadSkillCreationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/5/23 09:49
 * @description : 技能创建动态工厂方法
 * 通过反射在第一次创建某类技能对象时，将其构造函数添加到 map 中
 * 然后使用构造函数创建对象
 */
public class SkillTypeDynamicFactory implements SkillFactoryCreator{
    /*
    Skill 类型与构造函数 map
     */
    private Map<String, Constructor> factories = new HashMap<>();

    /**
     * 首次实例化某类 Skill 对象时
     * 将 Skill 类型与其构造函数添加到 map 中
     * @param type Skill 类型
     * @return 无参构造函数
     */
    private static Constructor load(String type){
        System.out.println("loading " + type);
        try {
            return Class
                    .forName("com.angers.project.onjava8.pattern.battle." + type)
                    .getConstructor();
        }catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new BadSkillCreationException(type);
        }
    }

    /**
     * 使用构造函数实例化对象
     * @param skillType 对应 NormalSkill 和 UltimateSkill
     * @return Skill 实例
     */
    @Override
    public Skill create(String skillType) {

        try {
            return (Skill) factories
                    // 检查 key 是否已存在，已存在则直接使用，不存在调用 load 方法
                    .computeIfAbsent(skillType,SkillTypeDynamicFactory::load)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BadSkillCreationException(skillType);
        }
    }
}
