package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 18:49
 * @description : 异常-finally
 */
public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while (true) {
            try {
                if (count ++ == 0){
                    throw  new ThreeException();
                }
                System.out.println("no exception");
            }catch (ThreeException e){
                System.out.println("Three Exception");
            } finally { // 无论是否抛出异常， finally 语句最终都会执行
                System.out.println("finally");
                if (count == 2) break;
            }
        }
    }
}

class ThreeException extends Exception {}