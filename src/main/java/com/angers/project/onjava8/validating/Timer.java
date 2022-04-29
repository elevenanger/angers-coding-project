package com.angers.project.onjava8.validating;
import static java.util.concurrent.TimeUnit.*;
/**
 * @author : liuanglin
 * @date : 2022/4/28 10:21
 * @description : 校验-计时器
 */
public class Timer {
    private final long startTime = System.nanoTime();
    public long duration(){
        return NANOSECONDS.toMillis(System.nanoTime() - startTime);
    }
    public static long duration(Runnable runnable){
        Timer timer = new Timer();
        runnable.run();
        return timer.duration();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println(timer.duration());
    }
}
