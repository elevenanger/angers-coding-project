package com.angers.project.onjava8.hiding;

/**
 * @author : liuanglin
 * @date : 2022/4/12 10:29
 * @description : private 方法或者 private final 方法，只是看起来可以覆盖，编译器不会报错
 * override 只能覆盖基类的接口
 * private 方法不属于基类的接口
 * 在派生类定义的相同的方法只是名称和参数相同派生类自身的方法而已，不是覆盖基类的方法
 */
public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate overridingPrivate = new OverridingPrivate();
        overridingPrivate.f();
        overridingPrivate.g();
    }

}

class WithFinals {
    private final void f(){
        System.out.println("WithFinals.f()");
    }
    private void g(){
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    public final void f(){
        System.out.println("OverridingPrivate.f()");
    }
    public void g(){
        System.out.println("OverridingPrivate.g()");
    }
}
