package com.angers.project.onjava8.pattern.trash;

/**
 * @author : liuanglin
 * @date : 2022/5/25 14:55
 * @description :
 */
public abstract class Visitor {
    protected double alTotal;
    protected double pTotal;
    protected double gTotal;
    protected double cTotal;
    protected String desc;

    Visitor(String desc) {
        this.desc = desc;
    }

    protected void show(String type,double value){
        System.out.printf(
                "%s %s : %.2f%n",type,desc,value);
    }

    public void total(){
        show("Total Aluminum",alTotal);
        show("Total Glass",gTotal);
        show("Total Paper",pTotal);
        show("Total CardBoard",cTotal);
    }
    abstract void visit(Aluminum aluminum);
    abstract void visit(Paper paper);
    abstract void visit(CardBoard cardBoard);
    abstract void visit(Glass glass);
}
