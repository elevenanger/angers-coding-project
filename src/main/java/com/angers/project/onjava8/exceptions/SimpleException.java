package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 08:34
 * @description : 异常 - 自定义异常类
 * 继承异常类即可
 */
// 通过继承 Exception 简单定义一个没有声明构造函数的异常类
public class SimpleException extends Exception{}

class ErrorSituation {
    // 对抛出异常的方法添加 throws Exception 签名
    private void f() throws SimpleException{
        System.out.println(getClass().getSimpleName() + ".f() " +
                "throws SimpleException");
        // 抛出异常
        throw new SimpleException();
    }

    public static void main(String[] args) throws SimpleException {
        ErrorSituation er = new ErrorSituation();
        // try - catch 语句，对可能出现异常的代码进行处理
        try {
            er.f();
        }catch (SimpleException e){
            System.out.println("Caught SimpleException!");
        }
    }
}
