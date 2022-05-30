package com.angers.project.onjava8.transobj;

import com.angers.project.onjava8.validating.Timer;

import java.io.*;

/**
 * @author : liuanglin
 * @date : 2022/5/30 09:05
 * @description : 比较序列化与克隆
 * 对象首先进行序列化然后反序列化
 * 实际上，对象是被克隆了
 */
class Thing1 implements Serializable {}

class Thing2 implements Serializable {
    Thing1 thing1 = new Thing1();
}

class Thing3 implements Cloneable {
    @Override
    protected Thing3 clone() {
        try {
            return (Thing3) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Thing4 implements Cloneable {
    private Thing3 thing3 = new Thing3();

    @Override
    protected Thing4 clone() {
        Thing4 thing4 = null;
        try {
            thing4 = (Thing4)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        thing4.thing3 = thing3.clone();
        return thing4;
    }
}
public class CompeteSerializationWithClone {
    public static final int SIZE = 100_000;

    public static void main(String[] args) throws Exception{
        Thing2[] a = new Thing2[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[i] = new Thing2();
        }
        Timer timer = new Timer();
        try (ByteArrayOutputStream buf = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(buf);){
            for (Thing2 thing2 : a){
                oos.writeObject(thing2);
            }
            try (ObjectInputStream ois =
                    new ObjectInputStream(
                            new ByteArrayInputStream(buf.toByteArray()));){
                Thing2[] c = new Thing2[SIZE];
                for (int i = 0; i < SIZE; i++) {
                    c[i] = (Thing2) ois.readObject();
                }
            }
        }
        System.out.println("通过序列化进行对象复制耗时 ： " + timer.duration());
        timer = new Timer();
        Thing4[] b = new Thing4[SIZE];
        for (int i = 0; i < SIZE; i++) {
            b[i] = new Thing4();
        }
        Thing4 [] d = new Thing4[SIZE];
        for (int i = 0; i < SIZE; i++) {
            d[i] = b[i].clone();
        }
        System.out.println("通过克隆进行对象复制耗时 ： " + timer.duration());
        /* output:
        通过序列化进行对象复制耗时 ： 258
        通过克隆进行对象复制耗时 ： 7
        Thing2 Thing4 都包含成员对象
        所以需要进行一些深拷贝的操作
        序列化更容易设置
        但是在实际复制对象的过程中需要做很多事情
        实现接口即可
        Cloneable clone() 方法需要进行很多额外的设置
        但是实际的拷贝操作则更为简单
        序列化至少比克隆慢一个数量级
         */
    }
}
