package com.angers.project.io;

import com.angers.project.inheritance.Employee;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class ObjectStream {

    public static String FILE_PATH = "/Users/liuanglin/data/employee.dat";

    public static void main(String [] args) throws IOException, ClassNotFoundException {

        /*
        序列化格式包括所有对象的类型以及数据域
        为每个对象分配一个序列号
        一个对象重复出现多次将存储为对于该序列号的引用
         */
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))){
            // 对象类需要实现 Serializable 接口
            Employee andy = Employee.getWellPaidInstance("andy");
            Employee carl = Employee.getWellPaidInstance("carl");
            outputStream.writeObject(andy);
            outputStream.writeObject(carl);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(FILE_PATH))){
            log.info(inputStream.readObject().toString());
            log.info(inputStream.readObject().toString());
        }
    }
}
