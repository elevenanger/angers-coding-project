package com.angers.project.onjava8.pattern.battle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author : liuanglin
 * @date : 2022/5/24 09:56
 * @description : 设计模式-策略模式
 */
public class SkillStrategy {
    /*
    在策略基类中定义算法函数
    不做具体实现
     */
    protected Function<CastSkill,List<CastSkill>> skillFunction;

    /**
     * 策略算法函数实现方法
     * 实例策略实例调用该方法则选择该策略
     * 也可以把策略和执行策略上下文都集中在一个类中实现
     * 这样就可以在一个类中控制所有策略的选择
     */
    public void  quadruple() {
        skillFunction = castSkill -> Arrays.asList(castSkill,castSkill,castSkill,castSkill);
    }

    public List<CastSkill> skillMultiplication(CastSkill castSkill){
        return skillFunction.apply(castSkill);
    }
}

class DoubleSkill extends SkillStrategy {
    /**
     * 子类中实现算法
     * 每一个子类对于算法不同的实现都是一个独立的策略
     */
    public DoubleSkill() {
        skillFunction = skill -> Arrays.asList(skill,skill);
    }
}
class TripleSkill extends SkillStrategy {
    public TripleSkill() {
        skillFunction = skill -> Arrays.asList(skill,skill,skill);
    }
}

/**
 * 策略代理类
 * 选择以及变更策略
 */
class SkillStrategySolver {
    /*
    策略基类作为属性
     */
    private SkillStrategy skillStrategy;

    /*
    在构造函数中传入策略
     */
    public SkillStrategySolver(SkillStrategy skillStrategy) {
        this.skillStrategy = skillStrategy;
    }

    /**
     * 应用策略中共同定义的函数算法
     * 不同策略实现不同的逻辑
     * @param skill 算法的入参
     * @return 算法的运算结果
     */
    List<CastSkill> skillTrigger(CastSkill skill){
        return skillStrategy.skillFunction.apply(skill);
    }

    /**
     * 改变策略
     * @param strategy 策略实例
     */
    void changeStrategy(SkillStrategy strategy){
        this.skillStrategy = strategy;
    }

    public static void main(String[] args) {
        SkillTypeFactory typeFactory = new SkillTypeFactory();
        UltimateSkill skill = (UltimateSkill) typeFactory.create("UltimateSkill");
        skill.setSkillName("Flood");
        skill.setDamage(230);
        SkillStrategySolver solver = new SkillStrategySolver(new DoubleSkill());
        solver.skillTrigger(skill).forEach(CastSkill::cast);
        solver.changeStrategy(new TripleSkill());
        solver.skillTrigger(skill).forEach(CastSkill::cast);

        SkillStrategy strategy = new SkillStrategy();
        strategy.quadruple();
        strategy.skillMultiplication(skill).forEach(CastSkill::cast);
    }
}