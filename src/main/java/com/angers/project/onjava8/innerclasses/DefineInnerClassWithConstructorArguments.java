package com.angers.project.onjava8.innerclasses;

/**
 * @author : liuanglin
 * @date : 2022/4/15 11:28
 * @description : 使用匿名内部类-构造其他类对象，需要构造的对象类构造函数需要传参
 */
public class DefineInnerClassWithConstructorArguments {
    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(10);
        System.out.println(wrapping.getPieceCount());
    }
}

class Parcel8 {
    public Wrapping wrapping (int x){
        /*
        构建继承 Wrapping 基类的匿名内部类
        传入适当的参数调用构造函数进行实例化
         */
        return new Wrapping(x){
            @Override
            public int getPieceCount() {
                return super.getPieceCount()*2;
            }
        };
    }
}
