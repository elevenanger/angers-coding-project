package com.angers.project.onjava8.reuse;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/12 08:46
 * @description : final 的用途
 */
public class FinalData {
    private static Random rand = new Random(93);
    private String id;
    public FinalData(String id) {
        this.id = id;
    }
    // 编译时常量
    private final int valueOne = 99;
    private final static int VALUE_TWO = 93;
    // public 常量
    public final static int VALUE_THREE = 19;
    /*
    非编译时常量
    final 修饰对象并不代表这个对象的值不能改变
    它是一个对象引用
    final 表示这个变量无法绑定另一个变量
    对于数组也一样，因为数组也是一个对象
     */
    private final int i4 = rand.nextInt(19);
    static final int INT_5 = rand.nextInt(19);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private final static Value VAL_3 = new Value(33);
    // 数组
    private final int[] ints = {1,2,3,4,5};

    @Override
    public String toString() {
        return "FinalData{" +
                "id='" + id + '\'' +
                ", valueOne=" + valueOne +
                ", i4=" + i4 +
                ", v1=" + v1 +
                ", v2=" + v2 +
                ", ints=" + Arrays.toString(ints) +
                '}';
    }

    public static void main(String[] args) {
        FinalData finalData1 = new FinalData("finalData1");
        finalData1.v2.i++;
        finalData1.v1 = new Value(9); // ok 不是 final 变量
        for (int v: finalData1.ints) {
            v++;
        }
        System.out.println(finalData1);
        System.out.println("creating new FinalData");
        FinalData finalData2 = new FinalData("finalData2");
        System.out.println(finalData1);
        System.out.println(finalData2);
    }
}

class Value {
    int i;
    public Value(int i) {
        this.i = i;
    }
}
