package com.angers.project.onjava8.pattern.trash.doubledispatch;

import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:10
 * @description : 垃圾桶集合
 */
public class TrashBinSet {
    public final List<TypedBin> binSet =
            Arrays.asList(
                    new AluminumBin(),
                    new CardBoardBin(),
                    new PaperBin(),
                    new GlassBin());

    /**
     * 对垃圾桶进行分类
     * @param bin 垃圾桶对象
     */
    public void sortedIntoBins(List bin){
        bin.forEach(aBin -> {
            TypedBinMember t = (TypedBinMember) aBin;
            if (!t.addToTypedBin(binSet))
                throw new RuntimeException(
                        "sortedIntoBins() can't add " + t
                );
        });
    }
}
