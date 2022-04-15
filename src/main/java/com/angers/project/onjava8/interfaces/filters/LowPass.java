package com.angers.project.onjava8.interfaces.filters;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:08
 * @description :
 */
public class LowPass extends Filter {
    double coutoff;
    public LowPass(double coutoff) {
        this.coutoff = coutoff;
    }

    @Override
    public Waveform process(Waveform waveform) {
        return waveform;
    }
}
