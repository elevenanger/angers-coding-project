package com.angers.project.onjava8.pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/20 18:17
 * @description : 设计模式-状态模式
 *
 * 状态设计模式和代理设计模式的主要区别在于其解决的问题
 * 代理主要用于：
 * 1、远程代理：作为不同地址空间对象的代理
 * 2、虚拟代理：提供懒初始化的机制创建消耗比较大的对象
 * 如果不需要创建此对象，则永远不需要消耗这些资源
 * 可以通过在使用对象的时候再创建对象以缩短应用的启动时间
 * 3、保护代理：可以使用代理对客户端程序的访问权限进行控制，避免所有的被代理对象的权限暴露给客户端应用
 * 智能引用：当访问被代理对象时执行额外的操作
 * 追踪某个特定对象的引用数量
 * 实现写时复制防止对象别名
 * 对特定方法调用进行计数
 *
 * 状态设计模式可以使用不同的实现
 * 代理和状态设计模式都是将方法调用传递给实现对象
 */
public class StateDemo {
    public static void main(String[] args) {
        /*
        首先使用的是 JungleSkillImplementation
        然后切换为 ShooterSkillImplementation
        成员对象可以动态变化
        即是在使用状态设计模式
         */
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