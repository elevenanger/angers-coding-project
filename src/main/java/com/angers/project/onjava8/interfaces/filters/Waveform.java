package com.angers.project.onjava8.interfaces.filters;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:06
 * @description : 接口-过滤器
 */
public class Waveform {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform{" +
                "id=" + id +
                '}';
    }
}
