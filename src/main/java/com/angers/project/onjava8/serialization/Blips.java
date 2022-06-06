package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/6 18:58
 * @description : 演示 Externalizable
 */
class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1");
    }

    /**
     * 写对象时的自定义操作
     * @param out the stream to write the object to
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    /**
     * 读对象时的自定义操作
     * @param in the stream to read data from in order to restore the object
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    /*
    构造函数必须声明为 public
    在反序列化时
    先调用默认的构造函数构造对象
    然后再调用 readExternal() 方法
     */
    public Blip2() {
        System.out.println("Blip2");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

class Blip3 implements Externalizable {
    private int i;
    private String s;

    /*
    默认的构造函数不会设置实例域 i 和 s 的值
     */
    public Blip3() {
        System.out.println("Blip3.Blip3");
    }

    public Blip3(int i, String s) {
        System.out.println("i = " + i + ", s = " + s);
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Blip3{" +
            "i=" + i +
            ", s='" + s + '\'' +
            '}';
    }

    /**
     * 为了在序列化的时候完整存储对象当前的状态
     * 需要将所有的数据通过 writeExternal 方法写入
     * @param out the stream to write the object to
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    /**
     * 同理：
     * 为了在反序列化的过程中完整取回对象写入时的状态
     * 需要在 readExternal 中取回所有的数据
     * @param in the stream to read data from in order to restore the object
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }
}

public class Blips {
    public static void main(String[] args) {
        Path path = Paths.get(CommonUtils.FILE_PATH,"/serialization/Blips.dat");
        System.out.println("构造对象 ： ");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        Blip3 b3 = new Blip3(93,"Anger");
        try(ObjectOutputStream out =
            new ObjectOutputStream(
                Files.newOutputStream(path))){
            System.out.println("保存对象 ： ");
            out.writeObject(b1);
            out.writeObject(b2);
            out.writeObject(b3);
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }
        System.out.println("取回对象 ： ");
        try (ObjectInputStream in =
            new ObjectInputStream(
                Files.newInputStream(path))){
            b1 = (Blip1) in.readObject();
            b2 = (Blip2) in.readObject();
            b3 = (Blip3) in.readObject();
        }catch (IOException | ClassNotFoundException exception){
            throw new RuntimeException(exception);
        }
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
