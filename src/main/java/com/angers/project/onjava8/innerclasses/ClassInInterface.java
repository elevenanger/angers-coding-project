package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 15:20
 * @description : 在接口中定义内部类
 */
public interface ClassInInterface {
    void f();
    class Test implements  ClassInInterface {
        @Override
        public void f() {
            System.out.println(getClass().getSimpleName() +".f()");
        }
    }

    public static void main(String[] args) {
        ClassInInterface classInInterface = new Test();
        classInInterface.f();
    }
}
