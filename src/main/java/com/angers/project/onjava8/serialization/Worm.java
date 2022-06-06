package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * @author : liuanglin
 * @date : 2022/6/6 17:28
 * @description : 演示对象序列化的过程
 */
class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class Worm implements Serializable{
    private static Random random = new Random(20);
    private Data [] d = {
        new Data(random.nextInt()),
        new Data(random.nextInt()),
        new Data(random.nextInt())
    };
    private Worm next;
    private char c;
    Worm(int i,char x){
        System.out.println("Worm.Worm " + i);
        c = x;
        if ( -- i > 0) next = new Worm(i,(char) (x + 1));
    }

    Worm(){
        System.out.println("Worm.Worm zero argument constructor");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(" : ");
        builder.append(c).append("(");
        for (Data data : d) {
            builder.append(data).append(" ");
        }
        builder.append(")");
        if (next != null) builder.append(next);
        return builder.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Path wormFile = Paths.get(CommonUtils.FILE_PATH + "worm.dat");
        Worm w = new Worm(6,'a');
        System.out.println( " w = " + w);
        /*
        将对象序列化
        写入到文件
         */
        try (ObjectOutputStream out =
            new ObjectOutputStream(
                Files.newOutputStream(wormFile))){
            out.writeObject("Worm Storage \n");
            out.writeObject(w);
        }
        /*
        对文件中的数据进行反序列化
        转换还原成对象
         */
        try (ObjectInputStream in =
            new ObjectInputStream(
                Files.newInputStream(wormFile))){
            String s = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + " w2 = " + w2);
        }
        /*
        将对象序列化为字节流
         */
        try (ByteArrayOutputStream bout =
            new ByteArrayOutputStream();
        ObjectOutputStream out2 =
            new ObjectOutputStream(bout)){
            out2.writeObject("Worm Storage \n");
            out2.writeObject(w);
            out2.flush();
            /*
            对字节流反序列化
            还原为对象
             */
            try (ObjectInputStream in2 =
                new ObjectInputStream(
                    new ByteArrayInputStream(
                        bout.toByteArray()))){
                String s = (String) in2.readObject();
                Worm w3 = (Worm) in2.readObject();
                System.out.println(s + " w3 = " + w3);
            }
        }
    }
}
