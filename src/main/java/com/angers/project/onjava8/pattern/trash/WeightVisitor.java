package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/27 10:35
 * @description :
 */
public class WeightVisitor extends Visitor{
    public WeightVisitor() {
        super("weight");
    }

    @Override
    void visit(Aluminum aluminum) {
        show("Aluminum", aluminum.weight);
        alTotal += aluminum.weight;
    }

    @Override
    void visit(Paper paper) {
        show("Paper", paper.weight);
        pTotal += paper.weight;
    }

    @Override
    void visit(CardBoard cardBoard) {
        show("CardBoard", cardBoard.weight);
        cTotal += cardBoard.weight;
    }

    @Override
    void visit(Glass glass) {
        show("Glass", glass.weight);
        gTotal += glass.weight;
    }
}
