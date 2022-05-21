package com.angers.project.onjava8.pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/20 18:17
 * @description : 设计模式-状态模式
 */
public class StateDemo {
    public static void main(String[] args) {
        SkillState jazz= new SkillState(new JungleSkillImplementation());
        jazz.skillName("Punch Dragon");
        jazz.skillRange(20);
        jazz.pointing(false);
        jazz.change(new ShooterSkillImplementation());
        jazz.skillName("Hex Bullet");
        jazz.skillRange(100);
        jazz.pointing(true);
    }
}

class SkillState implements SkillBase{
    private SkillState implementation;

    protected SkillState() {}

    SkillState(SkillState implementation) {
        this.implementation = implementation;
    }

    void change(SkillState newState) {
        this.implementation = newState;
    }

    @Override
    public String skillName(String name) {
        return implementation.skillName(name);
    }

    @Override
    public int skillRange(int range) {
        return implementation.skillRange(range);
    }

    @Override
    public boolean pointing(boolean pointing) {
        return implementation.pointing(pointing);
    }
}

class ShooterSkillImplementation extends SkillState {
    @Override
    public String skillName(String name) {
        return name;
    }

    @Override
    public int skillRange(int range) {
        return range + 100;
    }

    @Override
    public boolean pointing(boolean pointing) {
        return pointing;
    }
}

class JungleSkillImplementation extends SkillState {
    @Override
    public String skillName(String name) {
        return name;
    }

    @Override
    public int skillRange(int range) {
        return range;
    }

    @Override
    public boolean pointing(boolean pointing) {
        return pointing;
    }
}