package com.angers.project.onjava8.concurrent;

import com.angers.project.onjava8.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : liuanglin
 * @date : 2022/6/5 19:39
 * @description :
 */
public class ThreadSize {
    static class Dummy extends Thread {
        @Override
        public void run() {
            new Nap(0.1);
        }

        public static void main(String[] args) {
            ExecutorService exec = Executors.newCachedThreadPool();
            int count = 0;
            try {
                while (true){
                    exec.execute(new Dummy());
                    count ++;
                }
            }catch (Error error){
                System.out.println(error.getClass().getSimpleName() + " : " + count);
            }
            finally {
                exec.shutdown();
            }
        }
    }
}
