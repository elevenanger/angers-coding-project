package com.angers.project.onjava8.pattern.battle;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author : liuanglin
 * @date : 2022/5/23 16:06
 * @description : 随机技能-实现 Supplier 接口
 */
public class RandomSkillFactory implements Supplier<Skill> {

    /*
    技能创建器
    将不同技能的无参构造函数赋值给 RandomSkillCreator  的 create 方法
     */
    private final RandomSkillCreator [] randomSkillCreators;
    private Random random = new Random(93);
    public RandomSkillFactory(RandomSkillCreator... creators) {
        this.randomSkillCreators= creators;
    }
    @Override
    public Skill get() {
        /*
        从各个技能创建器中随机选取一个
        创建技能
         */
        return randomSkillCreators[random.nextInt(randomSkillCreators.length)]
                .create();
    }
}
