package com.angers.project.onjava8.pattern.trash.doubledispatch;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 08:56
 * @description :
 */
public class CardBoard extends com.angers.project.onjava8.pattern.trash.CardBoard
        implements TypedBinMember{
    public CardBoard(double weight) {
        super(weight);
    }

    @Override
    public boolean addToTypedBin(List<TypedBin> bins) {
        return bins.stream().anyMatch(
                typedBin -> typedBin.add(this)
        );
    }
}
