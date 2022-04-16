package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 12:02
 * @description : 在匿名内部类中使用外部参数
 */
public class DefineAnonymousInnerClassUseOuterArgument {
    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("hunan");
        destination.readLabel();
    }
}

class Parcel9 {
    /*
    在匿名内部类中需要使用外部的对象作为参数
    这个参数必须为 final 修饰的，一旦内部类对象初始化完成则无法改变
    final 关键字可以省略
     */
    public Destination destination(final String dest){
        return new Destination() {
            private final String label = dest;
            @Override
            public void readLabel() {
                System.out.println(getClass().getSimpleName() + " " + label);
            }
        };
    }
}
