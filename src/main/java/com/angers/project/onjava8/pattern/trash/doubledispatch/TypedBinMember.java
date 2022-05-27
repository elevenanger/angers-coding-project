package com.angers.project.onjava8.pattern.trash.doubledispatch;

import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 08:43
 * @description :
 */
public interface TypedBinMember {
    boolean addToTypedBin(List<TypedBin> bins);
}
