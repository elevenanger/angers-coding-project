package com.angers.project.onjava8.reuse;

/**
 * @author : liuanglin
 * @date : 2022/4/12 18:36
 * @description : static 方法不具备多态性
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        // static 方法与类相关，不是内部对象
        StaticSuper sub = new StaticSub();
        System.out.println(sub.dynamicGet());
        System.out.println(StaticSuper.staticGet());
        System.out.println(StaticSub.staticGet());
        /* output:
        staticSub.dynamicGet()
        StaticSuper.staticGet()
        StaticSub.staticGet()
         */
    }
}

class StaticSuper {
    public static String staticGet(){
        return "StaticSuper.staticGet()";
    }
    public String dynamicGet(){
        return "staticSuper.dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet(){
        return "StaticSub.staticGet()";
    }
    @Override
    public String dynamicGet() {
        return "staticSub.dynamicGet()";
    }
}
