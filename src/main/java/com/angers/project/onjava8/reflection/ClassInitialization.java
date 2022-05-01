package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.common.CommonUtils;

import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/4/30 20:32
 * @description : 反射-初始化类
 */
class Initable {
    static final int STATIC_FINAL = 93;
    static final int STATIC_FINAL2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 193;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 39;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random random = new Random(93);
    public static void main(String[] args) {
        /*
        初始化机制是懒加载机制
        创建 initable 引用不会触发初始化
        获取类的静态成员会强制触发类的初始化
         */
        Class initable = Initable.class;
        CommonUtils.printDivide("after create initable ref");
        System.out.println(Initable.STATIC_FINAL);
        System.out.println(Initable.STATIC_FINAL2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Initable3.class;
        CommonUtils.printDivide("after create initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
