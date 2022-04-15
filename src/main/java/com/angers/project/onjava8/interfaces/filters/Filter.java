package com.angers.project.onjava8.interfaces.filters;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:07
 * @description : 接口-过滤器
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform waveform){
        return waveform;
    }
}
