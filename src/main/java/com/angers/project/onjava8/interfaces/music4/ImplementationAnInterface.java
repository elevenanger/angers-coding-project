package com.angers.project.onjava8.interfaces.music4;

/**
 * @author : liuanglin
 * @date : 2022/4/13 15:58
 * @description : 实现一个接口
 * 接口是描述某些特征
 * 实现接口则是定义这些特征的具体行为
 */
public class ImplementationAnInterface {
    public static void main(String[] args) {
        System.out.println(Concept.DESC);
        Implementation implementation = new Implementation();
        implementation.idea1();
        implementation.idea2();
        /* output:
        CONCEPT
        Implementation.idea1()
        Implementation.idea2()
         */
    }
}

interface Concept {
    String DESC = "CONCEPT";
    /*
    接口中的方法都是隐式地声明为 public
     */
    void idea1();
    void idea2();
}

/*
使用 implements 关键字实现接口
 */
class Implementation implements Concept {
    /*
    接口的方法是隐式地声明 public 的
    实现接口的方法需要显式地声明为 public
     */
    @Override
    public void idea1() {
        System.out.println("Implementation.idea1()");
    }

    @Override
    public void idea2() {
        System.out.println("Implementation.idea2()");
    }
}

