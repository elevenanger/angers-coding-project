package com.angers.project.onjava8.transobj;

/**
 * @author : liuanglin
 * @date : 2022/5/30 09:33
 * @description : 层次结构下的 Clone 能力
 */
class Person {}

class Hero extends Person {}

class Scientist extends Person implements Cloneable {
    @Override
    public Scientist clone() {
        try {
            return (Scientist) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class GreatScientist extends Scientist {}

public class HierarchyCloneability {
    public static void main(String[] args) {
        /*
        直接集成 Object 的类默认是没有 clone() 方法的
        需要显式地实现 Cloneable 来获得克隆能力
        可以在集成层级中的任意层级增加克隆能力
        在此层级之下的层级将自动获得该能力
         */
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        GreatScientist g = new GreatScientist();
        s = s.clone();
        g = (GreatScientist) g.clone();
    }
}
