package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.Nap;
import com.angers.project.onjava8.common.CommonUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author : liuanglin
 * @date : 2022/6/7 08:14
 * @description : 演示 transient 关键字的用途
 */
class Logon implements Serializable {
    private Date date = new Date();
    private String userName;
    /*
    Serializable 序列化和反序列化是自动发生的
    对象中所有的状态都会被序列化
    如果想要控制某个实例域不被序列化
    使用 transient 声明该实例域
     */
    private transient String password;

    public Logon(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
            "date=" + date +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
public class TransientDemo {
    public static void main(String[] args) {
        Path path = Paths.get(CommonUtils.FILE_PATH,"/serialization/transientDemo.dat");
        Logon a = new Logon("Anger","123456");
        System.out.println(a);
        try (ObjectOutputStream out =
            new ObjectOutputStream(
                Files.newOutputStream(path)
            )){
            out.writeObject(a);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        new Nap(1);
        try (ObjectInputStream in =
            new ObjectInputStream(
                Files.newInputStream(path))){
            Logon a1 = (Logon) in.readObject();
            System.out.println("反序列化对象 ： \n" + a1);
        }catch (IOException | ClassNotFoundException exception){
            throw new RuntimeException(exception);
        }
        /* output :
        Logon{date=Tue Jun 07 08:20:56 CST 2022, userName='Anger', password='123456'}
        反序列化对象 ：
        Logon{date=Tue Jun 07 08:20:56 CST 2022, userName='Anger', password='null'}
         */
    }
}
