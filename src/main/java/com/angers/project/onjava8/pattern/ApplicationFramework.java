package com.angers.project.onjava8.pattern;

import java.util.stream.IntStream;

/**
 * @author : liuanglin
 * @date : 2022/5/20 11:18
 * @description : 设计模式-模板方法模式
 */
abstract class ApplicationFramework {
    /*
    基类的构造函数确保必要的初始化
    启动运行引用的 引擎
    应用程序开发者只需要定义 customize1() 和 customize2() 方法即可
     */
    ApplicationFramework() {
        templateMethod();
    }

    /*
    抽象方法
    继承此类需要实现的行为
    在模板方法中被调用
     */
    abstract void customize1(int n);
    abstract void customize2(int n);
    /*
    private 意味着自动的 final
    模板方法调用该类中的其它方法
    此方法不能被继承和覆盖
     */
    private void templateMethod(){
        IntStream.range(0,5).forEach(
                n -> {customize1(n);
                customize2(n);}
        );
    }
}

class MyApp extends ApplicationFramework {
    @Override
    void customize1(int n) {
        System.out.println(getClass().getSimpleName() + " customize1 " + n);
    }

    @Override
    void customize2(int n) {
        System.out.println(getClass().getSimpleName() + " customize2 " + n);
    }

    public static void main(String[] args) {
        new MyApp();
    }
}

class CarCare extends ApplicationFramework {
    @Override
    void customize1(int n) {
        System.out.println(getClass().getSimpleName() + " 已添加机油 " + n + " L");
    }

    @Override
    void customize2(int n) {
        System.out.println(getClass().getSimpleName() + " 保养总工时 " + n + " h");
    }

    public static void main(String[] args) {
        new CarCare();
    }
}