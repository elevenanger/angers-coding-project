package com.angers.project.onjava8.hiding.packageaccess;

/**
 * @author : liuanglin
 * @date : 2022/4/10 17:22
 * @description : 在只有 package 访问权限的类提供一个 public 构造函数
 * public 修饰的构造函数 PublicConstructor() 不能使之在这个 package 以外具备 public 访问权限
 */
class PublicConstructor {
    public PublicConstructor(){
        System.out.println(" PublicConstructor() ");
    }
}
