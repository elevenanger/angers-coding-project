package com.angers.project.onjava8.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author : liuanglin
 * @date : 2022/4/25 21:34
 * @description : 异常-关闭已检查的异常
 *
 */
public class TurnOffChecked {
    public static void main(String[] args) {
        WrapCheckedExceptions wce = new WrapCheckedExceptions();
        wce.throwRuntimeException(3);
        for (int i = 0; i <4 ; i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            }catch (SomeOtherException se){
                try {
                    throw se.getCause();
                }catch (FileNotFoundException e){
                    System.out.println("FileNotFoundException:" + e);
                }catch (IOException e){
                    System.out.println("IOException:" + e);
                }catch (Throwable throwable){
                    System.out.println("Throwable:" + throwable);
                }
            }

        }
    }
}

class SomeOtherException extends Exception {}

class WrapCheckedExceptions {
    /*
    使用 throw RuntimeException 关闭异常处理
     */
    void throwRuntimeException (int type) {

        try {
            switch (type){
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("hello");
                default:return;
            }
        }catch (RuntimeException | IOException e){
            throw new RuntimeException(e);
        }
    }
}