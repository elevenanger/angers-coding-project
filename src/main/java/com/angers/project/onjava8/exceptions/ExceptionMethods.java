package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 14:41
 * @description : 异常-异常类的方法
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("my exception");
        }catch (Exception e){
            System.out.println("catch exception.");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println("toString()"+e);
            System.out.println("e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
