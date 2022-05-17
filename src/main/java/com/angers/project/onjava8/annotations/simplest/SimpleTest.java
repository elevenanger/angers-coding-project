package com.angers.project.onjava8.annotations.simplest;

/**
 * @author : liuanglin
 * @date : 2022/5/16 08:40
 * @description : 注解-测试 simple 注解
 * 根据定义 Simple 注解的作用域
 * 该注解可以作用于相应的域
 */
@Simple
public class SimpleTest {
    @Simple
    int i;
    @Simple
    public SimpleTest() {
        System.out.println("SimpleTest Constructor");
    }
    @Simple
    public void foo(){
        System.out.println(getClass().getSimpleName() + ".foo()");
    }
    @Simple
    public void bar(int i){
        System.out.println(getClass().getSimpleName() + ".bar() " + i);
    }

    @Simple
    public static void main(String[] args) {
        @Simple
        SimpleTest simpleTest = new SimpleTest();
        simpleTest.foo();
        simpleTest.bar(11);
    }
}
