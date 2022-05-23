package com.angers.project.onjava8.pattern.battle.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/5/23 08:58
 * @description : 异常-技能创建异常
 */
public class BadSkillCreationException extends RuntimeException{
    public BadSkillCreationException(String message) {
        super(message);
    }
}
