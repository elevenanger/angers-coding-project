package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 16:39
 * @description : 实现内部类实现多个继承关系
 */
public class MultiImplementation {
    static void takeD(D d){
        d.d();
    }
    static void takeE(E e){
        e.e();
    }

    public static void main(String[] args) {
        F f = new F();
        takeD(f);
        takeE(f.makeE());
    }
}

class D {
    void d(){
        System.out.println(getClass().getSimpleName() + ".d()");
    }
}

abstract class E {
    abstract void e();
}

class F extends D {
    E makeE(){
        // 匿名内部类继承 E
        return new E(){
            @Override
            void e() {
                System.out.println(getClass().getSimpleName() + ".e()");
            }
        };
    }
}
