package com.angers.project.onjava8.housekeeping;

/**
 * @author : liuanglin
 * @date : 2022/4/7 11:04
 * @description : 终止条件表示所有 Book 对象都必须在它们被垃圾回收之前 checkIn
 * 但 main() 不会做这个操作
 * 如果没有 finalize() 来验证终止条件，这可能是一个很难找到的错误
 */
public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
