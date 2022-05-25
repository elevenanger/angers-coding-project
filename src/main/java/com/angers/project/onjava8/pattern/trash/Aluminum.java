package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:54
 * @description : 垃圾材料-铝
 */
public class Aluminum extends Trash{

    public Aluminum(double weight) {
        super(weight);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public double price() {
        return Price.ALUMINUM;
    }
}
