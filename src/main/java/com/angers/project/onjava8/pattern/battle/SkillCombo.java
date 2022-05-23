package com.angers.project.onjava8.pattern.battle;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:46
 * @description : 技能连招抽象类
 */
public abstract class SkillCombo {
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
