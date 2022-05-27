package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/27 10:16
 * @description :
 */
public class PriceVisitor extends Visitor{
    public PriceVisitor() {
        super("price");
    }

    @Override
    void visit(Aluminum aluminum) {
        double price = aluminum.weight * aluminum.price();
        show("Aluminum",price);
        alTotal += price;
    }

    @Override
    void visit(Paper paper) {
        double price = paper.price() * paper.weight;
        show("Paper",price);
        pTotal += price;
    }

    @Override
    void visit(CardBoard cardBoard) {
        double price = cardBoard.price() * cardBoard.weight;
        show("CardBoard",price);
        pTotal += price;

    }

    @Override
    void visit(Glass glass) {
        double price = glass.price() * glass.weight;
        show("Glass",price);
        pTotal += price;
    }
}
