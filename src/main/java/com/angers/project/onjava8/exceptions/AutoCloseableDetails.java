package com.angers.project.onjava8.exceptions;

/**
 * @author : liuanglin
 * @date : 2022/4/25 21:00
 * @description : 异常-实现 AutoCloseable 接口
 *
 */
public class AutoCloseableDetails {
    public static void main(String[] args) throws Exception {
        try (
                First first = new First();
                Second second = new Second();
                ){
        }
    }
}

class Reporter implements AutoCloseable {

    String name = getClass().getSimpleName();

    public Reporter() {
        System.out.println("creating " + name);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {}
class Second extends Reporter {}