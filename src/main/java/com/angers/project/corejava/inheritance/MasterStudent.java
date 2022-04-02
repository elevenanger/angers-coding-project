package com.angers.project.corejava.inheritance;

import lombok.extern.slf4j.Slf4j;

/**
 * 硕士
 */
@Slf4j
public class MasterStudent extends Student{

    /**
     * 一旦子类不是抽象类，则必须实现父类的抽象方法
     * @return descriptions
     */
    @Override
    public String getDescription() {
        return this.getName() + " is a master student";
    }

    /**
     * 构造函数
     */
    public MasterStudent(){
        setId();
    }

    public static void main (String [] args){

    }
}
