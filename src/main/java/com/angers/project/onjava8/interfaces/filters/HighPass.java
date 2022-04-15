package com.angers.project.onjava8.interfaces.filters;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:10
 * @description : 接口-过滤器
 */
public class HighPass extends Filter{
    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform waveform) {
        return waveform;
    }
}
