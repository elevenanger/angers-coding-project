package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:57
 * @description : 垃圾-玻璃材料
 */
public class Glass extends Trash{

    public Glass(double weight) {
        super(weight);
    }

    @Override
    public double price() {
        return Price.GLASS;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
