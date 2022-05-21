package com.angers.project.onjava8.pattern;

/**
 * @author : liuanglin
 * @date : 2022/5/20 17:03
 * @description : 设计模式-代理
 */
interface SkillBase {
    // 技能名称
    String skillName(String name);
    // 技能范围
    int skillRange(int range);
    // 是否指向型技能
    boolean pointing(boolean pointing);
}

class SkillProxy implements SkillBase{
    /*
    代理类中编排实现类对象
    代理实现类对象
    在实现类中实现具体的业务逻辑
     */
    private SkillImplementation implementation = new SkillImplementation();

    /*
    代理类进行接口转发
    不进行业务逻辑的处理
    将接口与实现分离
    或者做一层简单的校验或者检查逻辑
     */
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

class SkillImplementation implements SkillBase {
    /*
    实现类并不需要和代理类实现相同的接口
    但是使用相同接口可以更好实现接口与实现方法的一一对应关系
     */
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
public class ProxyDemo {
    public static void main(String[] args) {
        SkillBase skill = new SkillProxy();
        System.out.println(skill.skillName("狂风绝息斩"));
        System.out.println(skill.skillRange(10));
        System.out.println(skill.pointing(false));
    }
}
