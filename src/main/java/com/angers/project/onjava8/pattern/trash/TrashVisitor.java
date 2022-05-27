package com.angers.project.onjava8.pattern.trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 10:37
 * @description :
 */
public class TrashVisitor {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        ParseTrash.fillBin("trash",bin);
        List<Visitor>visitors = Arrays.asList(
                new PriceVisitor(),
                new WeightVisitor());
        bin.forEach(
                trash -> visitors.forEach(trash::accept));
        visitors.forEach(Visitor::total);
    }
}
