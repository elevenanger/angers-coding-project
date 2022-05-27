package com.angers.project.onjava8.pattern.trash.doubledispatch;

/**
 * @author : liuanglin
 * @date : 2022/5/27 09:02
 * @description :
 * 每种垃圾类型对应的垃圾桶
 * 继承 TypedBin 类
 * 基类 TypedBin 的所有 add() 方法都返回 false
 * 所以需要在子类中重写对应的 add() 方法
 * 使对应的垃圾类型能够返回true
 */
public class AluminumBin extends TypedBin {
    public AluminumBin() {
        super("Aluminum");
    }

    @Override
    public boolean add(Aluminum aluminum) {
        return addIt(aluminum);
    }
}