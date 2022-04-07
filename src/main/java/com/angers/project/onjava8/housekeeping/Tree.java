package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/6 18:55
 * @description : 提供不同的构造函数来构造一个对象、
 * 不同构造函数的方法名相同，但是参数不同
 * 这种机制称之为 重载（overload）
 */
public class Tree {

    int height;

    Tree(){
        System.out.println("Planting a seedling...");
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        System.out.println("Creating a new Tree that is " + height + " feet tall.");
    }

    void info(){
        System.out.println("Tree is " + height + " feet tall.");
    }

    /**
     * 重载方法
     * @param message 信息
     */
    void info(String message) {
        System.out.println(message + " : Tree is " + height + " feet tall.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree tree = new Tree(i);
            tree.info();
            tree.info("overload method");
        }
        // 重载构造函数
        Tree t = new Tree();
        t.info();
    }
}
