package com.angers.project.onjava8.pattern.trash.doubledispatch;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:05
 * @description :
 */
public class PaperBin extends TypedBin{
    public PaperBin() {
        super("Paper");
    }

    @Override
    public boolean add(Paper paper) {
        return addIt(paper);
    }
}
