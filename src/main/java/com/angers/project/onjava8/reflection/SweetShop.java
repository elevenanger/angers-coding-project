package com.angers.project.onjava8.reflection;

import com.angers.project.onjava8.common.CommonUtils;

/**
 * @author : liuanglin
 * @date : 2022/4/30 17:48
 * @description : 反射-加载
 * 需要在运行时使用类信息，则需要获得正确的 CLass 对象引用
 */
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
class Gum {
    static {
        System.out.println("Loading Gum");
    }
}
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        CommonUtils.printDivide("inside SweetShop.main()");
        new Candy();
        CommonUtils.printDivide("after creating candy");
        try {
            // 类只有在需要的时候才加载,Class.forName() 如果特定的类尚未加载，则加载该类
            Class.forName("com.angers.project.onjava8.reflection.Gum");
        }catch (ClassNotFoundException e){
            System.out.println("couldn't find gum");
            System.out.println(e);
        }
        CommonUtils.printDivide("after Class.forName(Gum)");
        new Cookie();
        CommonUtils.printDivide("After create cookie.");
    }
}
