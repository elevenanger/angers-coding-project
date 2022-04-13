package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/12 09:35
 * @description : blank final 是没有初始化值的 final 字段
 */
public class BlankFinal {
    private final int i = 0; // 完成初始化的 final 域
    private final int j; // blank final
    private final Poppet poppet ; // blank final 引用
    /*
    编译器确保在使用前初始化 blank final
    类中的 final 字段对于每个对象都可以不同
    同时保持其不可变的特性
     */
    public BlankFinal() {
        // 没有在定义时初始化的 blank final 必须在构造函数中完成初始化
        j = 1; // 初始化 blank final
        poppet = new Poppet(1); // 初始化 blank final 引用
    }
    public BlankFinal(int j) {
        this.j = j;
        poppet = new Poppet(j);
    }
    @Override
    public String toString() {
        return "BlankFinal{" +
                "i=" + i +
                ", j=" + j +
                ", poppet=" + poppet +
                '}';
    }
    public static void main(String[] args) {
        BlankFinal blankFinal1 = new BlankFinal();
        System.out.println(blankFinal1.toString());
        BlankFinal blankFinal2 = new BlankFinal(93);
        System.out.println(blankFinal2.toString());
    }
}

class Poppet {
    private int i;
    public Poppet(int i) {
        this.i = i;
    }
    @Override
    public String toString() {
        return "Poppet{" +
                "i=" + i +
                '}';
    }
}
