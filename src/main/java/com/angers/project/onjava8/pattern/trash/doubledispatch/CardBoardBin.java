package com.angers.project.onjava8.pattern.trash.doubledispatch;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:09
 * @description :
 */
public class CardBoardBin extends TypedBin{
    public CardBoardBin() {
        super("CardBoard");
    }

    @Override
    public boolean add(CardBoard cardBoard) {
        return addIt(cardBoard);
    }
}
