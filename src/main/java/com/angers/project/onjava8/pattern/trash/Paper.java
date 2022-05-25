package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:58
 * @description : 垃圾-纸质材料
 */
public class Paper extends Trash{

    public Paper(double weight) {
        super(weight);
    }

    @Override
    public double price() {
        return Price.PAPER;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
