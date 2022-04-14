package com.angers.project.onjava8.interfaces;

/**
 * @author : liuanglin
 * @date : 2022/4/13 19:46
 * @description : 接口-一个类实现多个接口
 * 如果这些接口中存在方法签名相同的 default 方法
 * 则会产生冲突
 */
public class MultiImplementationCollision {
    public static void main(String[] args) {
        Bobby bobby = new Bobby();
        bobby.bob();
        bobby.bob(1);
        /* output:
        Bobby::bob
        Bob4::bob
         */
    }
}

interface Bob1 {
    default void bob(){}
}

interface Bob2 {
    default void bob(){}
}

interface Bob3 {
    default void bob(int i){
        System.out.println("Bob3::bob");
    }
}

interface Bob4 {
    default int bob(int i){
        System.out.println("Bob4::bob");
        return i;
    }
}

/*
Java 方法签名包括方法名和参数列表类型
编译器以此来区分唯一的方法
返回类型不是方法签名的一部分
不能因此来区分方法

MultiImplementationCollision.java:21:
错误: 类 Bob从类型 Bob1 和 Bob2 中继承了bob() 的不相关默认值
class Bob implements Bob1,Bob2{}
^
1 个错误

class Bob implements Bob1,Bob2{}
 */

// ok，因为 Bob3.bob() 和 Bob1.bob() 参数列表不同，方法签名不同
class Bob implements Bob1,Bob3 {}

/*
MultiImplementationCollision.java:47:
错误: 类型Bob4和Bob3不兼容; 两者都定义了bob(int), 但却带有不相关的返回类型
class BobNew implements Bob3,Bob4{}
^
1 个错误

class BobNew implements Bob3,Bob4{}
 */

// 重写冲突方法可以解决
class Bobby implements Bob1,Bob2,Bob3 {
    @Override
    public void bob() {
        System.out.println("Bobby::bob");
    }
}
