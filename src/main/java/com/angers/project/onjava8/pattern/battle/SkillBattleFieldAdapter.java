package com.angers.project.onjava8.pattern.battle;

import com.angers.project.onjava8.Nap;

/**
 * @author : liuanglin
 * @date : 2022/5/25 08:48
 * @description : 技能-战场 适配器模式
 * 适配器模式：将拥有的类型转换成目标接口类型
 * 适配器类实现目标接口
 * 实现目标接口方法
 * 在目标接口方法组合已拥有对象类型的方法
 */
public class SkillBattleFieldAdapter implements SkillInfluence{
    /*
    战场 拥有的对象类型
     */
    private BattleField battleField;

    public SkillBattleFieldAdapter(BattleField battleField) {
        this.battleField = battleField;
    }

    /**
     * 目标接口方法的实现
     * 适配器实现接口中的方法
     * 使用 Skill  和 BattleField 的方法
     * 组成接口方法
     */
    @Override
    public void influence() {
        battleField.forward();
        battleField.backward();
    }

    public static void main(String[] args) {
        BattleField battleField = new WaterField();
        SkillBattleFieldAdapter battleFieldAdapter =
                new SkillBattleFieldAdapter(battleField);
        battleFieldAdapter.influence();
    }
}

/**
 * 使用的方式
 * 定义方法
 * 目标接口类型对象作为参数
 * 在方法中调用目标接口类型的方法
 */
class SkillCastInBattleField {
    public void castInField(SkillInfluence influence){
        influence.influence();
    }
}

/**
 * 使用的方法
 * 将适配器集成到使用的方式中
 */
class SkillCastInBattleField2 extends  SkillCastInBattleField {
    public void castInField(BattleField battleField) {
        new SkillBattleFieldAdapter(battleField).influence();
    }
}

/**
 * 将适配器继承在拥有对象类型中
 * 拥有的对象类型实现目标接口类型
 * 在拥有对象类型中实现目标接口方法
 */
class MudField extends BattleField implements SkillInfluence{
    @Override
    public void forward() {
        System.out.println(getClass().getSimpleName() + " take forward effect 0.2");
        new Nap(0.2);
    }

    @Override
    public void backward() {
        System.out.println(getClass().getSimpleName() + " take backward effect 0.1");
        new Nap(0.1);
    }

    /**
     * 适配器
     */
    @Override
    public void influence() {
        forward();
        backward();
    }
}

/**
 * 将适配器作为内部类集成在当前拥有类型的类中
 */
class SteamField extends BattleField {
    private class SteamFieldAdapter implements SkillInfluence {
        @Override
        public void influence() {
            forward();
            backward();
        }
    }

    public SkillInfluence skillInfluence(){
        return new SteamFieldAdapter();
    }
    @Override
    public void forward() {
        System.out.println(getClass().getSimpleName() + " take forward effect 0.2");
        new Nap(0.2);
    }

    @Override
    public void backward() {
        System.out.println(getClass().getSimpleName() + " take backward effect 0.1");
        new Nap(0.1);
    }
}

class AdapterDemo {
    public static void main(String[] args) {
        /*
        第一种方式
         */
        SkillCastInBattleField useSkillCastInBattleField = new SkillCastInBattleField();
        BattleField haveBattleField = new WaterField();
        SkillInfluence wantInfluence = new SkillBattleFieldAdapter(haveBattleField);
        useSkillCastInBattleField.castInField(wantInfluence);
        /*
        第二种使用方式
         */
        SkillCastInBattleField2 useSkillCastInBattleField2 = new SkillCastInBattleField2();
        useSkillCastInBattleField2.castInField(haveBattleField);
        /*
        第三种方式
         */
        MudField haveMudField = new MudField();
        useSkillCastInBattleField.castInField(haveMudField);
        /*
        第四种方式
         */
        SteamField steamField = new SteamField();
        useSkillCastInBattleField.castInField(steamField.skillInfluence());
    }
}