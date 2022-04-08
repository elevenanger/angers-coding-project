package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 10:56
 * @description : 使用 finalize() 检查一个对象有没有被正确的清理掉
 */
public class Book {

    boolean checkedOut = false;

    Book(boolean checkOut){
        checkedOut = checkOut;
    }

    void checkIn(){
        checkedOut = false;
    }

    /*
    对象回收的时候执行该方法
    进行检查，输出日志
    通过日志检查该对象回收时的状态
     */
    @Override
    public void finalize(){
        if (checkedOut)
            System.out.println("Error : checked out!");
    }

}
