package com.angers.project.onjava8.pattern.trash.doubledispatch;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 08:53
 * @description :
 */
public class Aluminum extends com.angers.project.onjava8.pattern.trash.Aluminum
        implements TypedBinMember{
    public Aluminum(double weight) {
        super(weight);
    }

    @Override
    public boolean addToTypedBin(List<TypedBin> bins) {
        return bins.stream().anyMatch(typedBin -> typedBin.add(this));
    }
}
