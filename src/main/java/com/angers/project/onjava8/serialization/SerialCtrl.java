package com.angers.project.onjava8.serialization;

import java.io.*;

/**
 * @author : liuanglin
 * @date : 2022/6/7 08:27
 * @description : 控制 Serializable 序列化和反序列化的过程
 */
public class SerialCtrl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtrl(String a, String b) {
        this.a = "not transient " + a;
        this.b = "transient " + b;
    }

    @Override
    public String toString() {
        return "SerialCtrl{" +
            "a='" + a + '\'' +
            ", b='" + b + '\'' +
            '}';
    }

    /**
     * 定义和此方法签名一致的 writeObject()
     * Serializable 将会使用该方法进行序列化
     */
    private void writeObject(ObjectOutputStream stream)
        throws IOException {
        /*
        调用 defaultWriteObject() 方法
        完成默认的序列化操作
         */
        stream.defaultWriteObject();
        // 自定义序列化过程序列化 transient 实例域
        stream.writeObject(b);
    }

    /**
     * 与 writeObject() 方法同样的原理执行反序列化操作
     */
    private void readObject(ObjectInputStream stream)
        throws IOException ,ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws Exception{
        SerialCtrl serialCtrl = new SerialCtrl("T1","T2");
        System.out.println("序列化之前 \n " + serialCtrl);
        try (ByteArrayOutputStream buf =
            new ByteArrayOutputStream();
            ObjectOutputStream out =
            new ObjectOutputStream(buf)){
            out.writeObject(serialCtrl);
            try (ObjectInputStream in =
                new ObjectInputStream(
                    new ByteArrayInputStream(buf.toByteArray()))){
                SerialCtrl serialCtrl2 = (SerialCtrl) in.readObject();
                System.out.println("反序列化之后 \n" + serialCtrl2);
            }
        }
    }
}
