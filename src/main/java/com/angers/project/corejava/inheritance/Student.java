package com.angers.project.corejava.inheritance;

/**
 * 学生类
 * 父类为抽象类，子类也为抽象类
 * 父类的抽象方法，抽象的子类可以不做具体实现
 */
public abstract class Student extends Person{

    /**
     * 抽象的子类可以对父类的抽象方法进行定义，该类的子类则无需再定义该方法
     * @return description
     */
    @Override
    public String getDescription(){
        return "";
    }

}
