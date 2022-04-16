package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 12:25
 * @description : 内部类-使用内部类构造函数初始化实例域
 * 匿名内部类的限制：
 * 使用匿名内部类只能继承一个类或者实现接口中的一种
 */
public class InitializeFieldByAnonymous {

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("hunan");
        destination.readLabel();
    }
}

class Parcel10 {
    /*
    这里的 final String dest 必须为 final，因为它直接被内部类使用
    使用匿名内部类初始化实例域
    但是这种做法有个限制就是无法重载该初始化器
    所以就只能有一个这样的构造函数
     */
    Destination destination(final String dest){
        return new Destination() {
            private final String label = dest;
            @Override
            public void readLabel() {
                System.out.println(label);
            }
        };
    }
}
