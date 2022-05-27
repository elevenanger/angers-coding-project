package com.angers.project.onjava8.pattern.trash.doubledispatch;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:06
 * @description :
 */
public class GlassBin extends TypedBin{
    public GlassBin() {
        super("Glass");
    }

    @Override
    public boolean add(Glass glass) {
        return addIt(glass);
    }
}
