package com.angers.project.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ReadData extends ReadDataBasement{

    public static final String FILE_PATH = "/Users/liuanglin/data/localfile.txt";

    /**
     * 将输入的字符串写入指定的文件中，在代码逻辑中捕获异常
     * @param in 输入的字符串
     * 重写超类的方法
     * 如果超类没有使用 throws 说明符，则重写改方法的子类只能在方法中捕获异常
     * 不能在子类中添加比超类更多的 throws 说明符
     * 子类通过 throws 声明的异常不能比父类更通用
     */
    public void readData(String in) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILE_PATH,true);
            fos.write(in.getBytes(StandardCharsets.UTF_8));
            /*
            使用 | 分割符号，可以在一个 catch 语句中捕获多个异常
            只有当各个异常之间没有继承关系才需要使用这种方法
            当捕获多个异常，e 将被隐式地声明为 final ，无法再为其另外赋值
            捕获多个异常不仅仅使代码更简洁，也会更高效
             */
        }catch (FileNotFoundException | FileFormatException e){
            /*
            如果抛出 catch 语句中已经指定的其中一个异常
            程序将会跳过剩余 try 语句中的代码，直接执行 catch 该异常的代码
            如果没有抛出任何异常，将会不执行任何 catch 语句中的代码
            如果程序抛出异常是任何 try 语句都没有捕捉到的异常，方法将会直接结束
            我们只能寄希望于调用该方法的代码以及捕捉了这个异常
             */
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            /*
            e.getMessage() 异常的元信息
            e.getClass().getName() 抛出异常的实际对象类型
             */
            log.info(e.getClass().getName()+e.getMessage());
        }
        /*
        无论是否捕获异常，finally 语句都会执行，即使在捕获的异常中又抛出新的异常
        finally 设计意图旨在清理需要清理或者释放的资源
        不要在 finally 逻辑中定义控制流（return,throw,break,continue）
         */
        finally {
            try {
                if (fos!=null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 try-with-resource 声明资源
     * @param in 输入信息
     */
    public void readDataAndTryWithResources(String in){
        /*
        对于实现 AutoClosable 接口的资源，可以使用 try-with-resource 声明
        可以指定多个资源
        当 try 逻辑正常结束或者异常退出，会自动调用所有资源的 close() 方法，与 finally 中定义 close() 方法一样
        当 try 和 close() 都发生异常时，会被 try-with-resource 声明处理掉
         */
        try (FileInputStream is  = new FileInputStream(FILE_PATH);
             FileOutputStream fos = new FileOutputStream(FILE_PATH,true)){
            fos.write(is.read());
            fos.write(in.getBytes(StandardCharsets.UTF_8));
        }catch (FileNotFoundException e){
            log.info(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param in 输入字符串
     * @throws FileFormatException 文件格式异常
     * 子类不能声明比父类更通用的异常
     */
    @Override
    public void readDataAndThrowsExceptions(String in) throws FileFormatException{

    }

    /**
     * 将输入的数据写入指定的文件中,代码中不捕获异常
     * @param in 输入的字符串
     * @throws IOException io异常
     * 在方法上使用 throws 说明符表示该方法可能会抛出的异常，传递给该方法的调用者
     * 调用此方法的需要对此异常进行捕获或者继续使用 throws 说明符传递到更上层的调用者
     * 对于知道如何处理的异常，在方法中使用 catch 进行处理
     * 对于不知道如何处理的异常，则传递给调用方进行处理
     */
    public static void readDataToLocalFiles (String in) throws IOException{
        FileOutputStream fos = null;
        fos = new FileOutputStream(FILE_PATH,true);
        fos.write(in.getBytes(StandardCharsets.UTF_8));
        fos.close();
    }

    public static void main(String [] args) {
        // 调用使用 throws 说明符的方法，需要对异常进行捕获或者在调用者方法也使用 throws 说明符进行传播
        try {
            readDataToLocalFiles("crazy");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}