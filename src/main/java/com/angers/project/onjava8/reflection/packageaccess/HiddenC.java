package com.angers.project.onjava8.reflection.packageaccess;

import com.angers.project.onjava8.reflection.interfacea.A;

/**
 * @author : liuanglin
 * @date : 2022/5/5 16:39
 * @description :反射-隐藏 C 的内容
 */
public class HiddenC {
    /**
     * 构建一个 A 接口实例 此类中唯一的 public 方法
     * @return A 接口实例
     */
    public static A makeA(){
        return new C();
    }
}

/*
使用内部类隐藏实现
 */
class C implements A {
    @Override
    public void f() {
        System.out.println("C.f()");
    }

    public void g() {
        System.out.println("C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
