package com.angers.project.onjava8.compare;

/**
 * @author : liuanglin
 * @date : 2022/6/2 08:37
 * @description : 比较对象是否相等
 */
public class DefaultComparison {
    private int i;
    private int j;
    private int k;

    public DefaultComparison(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public static void main(String[] args) {
        DefaultComparison a = new DefaultComparison(1,2,3);
        DefaultComparison b = new DefaultComparison(1,2,3);
        System.out.println(a == b);
        System.out.println(a == a);
    }
}
