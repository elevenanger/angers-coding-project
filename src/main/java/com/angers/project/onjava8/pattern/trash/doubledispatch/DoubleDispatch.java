package com.angers.project.onjava8.pattern.trash.doubledispatch;

import com.angers.project.onjava8.pattern.trash.ParseTrash;
import com.angers.project.onjava8.pattern.trash.Trash;
import com.angers.project.onjava8.pattern.trash.TrashValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:24
 * @description :
 */
public class DoubleDispatch {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("trash.doubledispatch",bin);
        TrashBinSet bins = new TrashBinSet();
        bins.sortedIntoBins(bin);
        bins.binSet.forEach(
                typedBin -> TrashValue.sum(typedBin.bin(), typedBin.type)
        );
        TrashValue.sum(bin,"Trash");
    }
}
