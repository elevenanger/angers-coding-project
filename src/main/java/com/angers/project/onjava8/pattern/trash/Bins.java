package com.angers.project.onjava8.pattern.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/25 15:18
 * @description : 垃圾分类
 */
public class Bins {
    // 垃圾桶的全部垃圾
    final List<Trash> bin;
    /*
    根据分类后的各种垃圾的集合
    新增一种垃圾则新增一个集合
     */
    final List<Aluminum> aluminums = new ArrayList<>();
    final List<Paper> papers = new ArrayList<>();
    final List<Glass> glasses = new ArrayList<>();
    final List<CardBoard> cardBoards = new ArrayList<>();

    /**
     * 垃圾分类
     * 新增一种垃圾则新增一个 instanceof 分类逻辑
     * @param source 垃圾桶的所有垃圾
     */
    public Bins(List<Trash> source) {
        this.bin = new ArrayList<>(source);
        bin.forEach(
            trash -> {
                if (trash instanceof Aluminum) aluminums.add((Aluminum) trash);
                if (trash instanceof Paper) papers.add((Paper) trash);
                if (trash instanceof Glass) glasses.add((Glass) trash);
                if (trash instanceof CardBoard) cardBoards.add((CardBoard) trash);
            }
        );
    }

    /**
     * 展示分类后各种垃圾的金额合
     * 新增一种垃圾则新增一行计算代码
     */
    public void show() {
        TrashValue.sum(aluminums,"Aluminum");
        TrashValue.sum(papers,"Paper");
        TrashValue.sum(glasses,"Glass");
        TrashValue.sum(cardBoards,"Cardboard");
    }
}
