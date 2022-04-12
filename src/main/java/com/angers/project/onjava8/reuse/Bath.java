package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/11 09:54
 * @description : 构造函数初始化与组合
 */
public class Bath {
    private String s1 = "happy"; // 定义时初始化
    private String s2 = "Happy";
    private String s3;
    private String s4;
    private Soap castile;
    private int i;
    private float toy;
    public Bath(){
        System.out.println("Bath()");
        // 在构造函数中完成初始化
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();
    }
    // 实例初始化,会在构造函数之前执行
    { i = 93;}
    @Override
    public String toString() {
        /*
        懒初始化
        在实际使用的时候完成初始化
         */
        if (s4 == null) s4 = "Fun";
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castile=" + castile +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }
    public static void main(String[] args) {
        Bath bath = new Bath();
        System.out.println(bath);
        /* output
        Bath()
        Soap
        Bath{s1='happy', s2='Happy', s3='Joy', s4='Fun', castile=Soap{s='Constructed'}, i=93, toy=3.14}
         */
    }
}

class Soap {
    private String s;
    Soap(){
        System.out.println("Soap");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return "Soap{" +
                "s='" + s + '\'' +
                '}';
    }
}
