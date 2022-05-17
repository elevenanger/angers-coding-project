package com.angers.project.onjava8.annotations.ifx;

/**
 * @author : liuanglin
 * @date : 2022/5/16 10:53
 * @description : 注解-乘法器
 */
@ExtractInterface(interfaceName = "IMultiplier")
public class Multiplier {
    public boolean flag = false;
    private int n = 0;
    public int multiply(int x,int y){
        int total = 0;
        for (int j = 0; j < x; j++) {
            total = add(total,y);
        }
        return total;
    }

    private int add(int x,int y){
        return x + y;
    }
    public double timesTen(int x){
        return x * 10;
    }

    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println(m.multiply(11,20));
    }
}
