package com.angers.project.onjava8.interfaces.filters;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:11
 * @description : 接口-过滤器
 */
public class BandPass extends Filter {
    double lowCutoff;
    double highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform waveform) {
        return waveform;
    }
}
