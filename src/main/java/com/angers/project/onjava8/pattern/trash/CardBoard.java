package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:59
 * @description : 垃圾-硬纸板材料
 */
public class CardBoard extends Trash{

    public CardBoard(double weight) {
        super(weight);
    }

    @Override
    public double price() {
        return Price.CARDBOARD;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
