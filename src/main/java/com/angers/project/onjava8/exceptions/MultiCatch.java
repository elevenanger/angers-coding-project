package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 14:49
 * @description : 异常-捕捉处理多个异常
 */
public class MultiCatch {
    static void f() throws Except1,Except2,Except3,Except4{}
    static void process(){
        System.out.println("process()");
    }
    static void process1(){
        System.out.println("process1()");
    }
    public static void main(String[] args) {
        // 为每一个异常类写一个 catch 子句
        try {
            f();
        }catch (Except1 e){
            process();
        }catch (Except2 e){
            process();
        }catch (Except3 e){
            process();
        }catch (Except4 e){
            process();
        }
        // 使用 | 分隔每个异常类，进行统一处理
        try {
            f();
        }catch (Except4|Except3|Except2|Except1 e){
            process();
        }
        // 对异常进行区分，不同的异常做不同的处理
        try {
            f();
        }catch (Except1|Except2 e){
            process();
        }catch (Except3|Except4 e){
            process1();
        }
    }
}

class BaseExcept1 extends Exception {}
class BaseExcept2 extends Exception {}
class BaseExcept3 extends Exception {}
class BaseExcept4 extends Exception {}
class Except1 extends BaseExcept1{}
class Except2 extends BaseExcept2{}
class Except3 extends BaseExcept3{}
class Except4 extends BaseExcept4{}
