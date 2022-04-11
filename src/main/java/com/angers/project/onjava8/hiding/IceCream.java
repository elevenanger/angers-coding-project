package com.angers.project.onjava8.hiding;

/**
 * @author : liuanglin
 * @date : 2022/4/10 16:47
 * @description : 冰激凌
 */
public class IceCream {
    public static void main(String[] args) {
        /*
        Sundae sundae = new Sundae(); 不能直接调用
        因为 Sundae() 是 private 访问权限
        private 意味着该成员只有它所在的类有权限访问
        包括该类的方法

        在这个场景下
        private 可以控制只能从特定的方法创建 Sundae 对象
         */
        // Sundae sundae = new Sundae();
        Sundae.makeASundae();
    }
}
