package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/14 14:48
 * @description : 接口-实现冲突
 * 尽量避免在实现的不同接口和继承的类中定义同名的方法
 */
public class InterfaceCollision {}

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1,I2{
    @Override
    public void f() {}

    @Override
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {
    @Override
    public int f() {
        return 1;
    }
}
/*
not ok
class C5 extends C implements I1 {
    @Override
    public int f() {
        return super.f();
    }
}
 */

/*
not ok
interface I4 extends I1,I3{}
 */
