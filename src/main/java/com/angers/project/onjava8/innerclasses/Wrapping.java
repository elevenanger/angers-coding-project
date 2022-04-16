package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 11:24
 * @description : 包裹-包装
 */
public class Wrapping {
    // 打包件数
    private final int pieceCount;

    public Wrapping(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public int getPieceCount() {
        return pieceCount;
    }
}
