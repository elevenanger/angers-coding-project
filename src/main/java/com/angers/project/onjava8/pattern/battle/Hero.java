package com.angers.project.onjava8.pattern.battle;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:52
 * @description : 英雄类
 */
public class Hero {
    private List<NormalSkill> normalSkills;
    private UltimateSkill ultimateSkill;

    public List<NormalSkill> getNormalSkills() {
        return normalSkills;
    }

    public void setNormalSkills(NormalSkill ... normalSkills) {
        this.normalSkills = Arrays.stream(normalSkills).collect(Collectors.toList());
    }

    public UltimateSkill getUltimateSkill() {
        return ultimateSkill;
    }

    public void setUltimateSkill(UltimateSkill ultimateSkill) {
        this.ultimateSkill = ultimateSkill;
    }
}
