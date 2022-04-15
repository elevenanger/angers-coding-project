package com.angers.project.onjava8.interfaces.interfaceprocessor;

import com.angers.project.onjava8.interfaces.filters.*;

/**
 * @author : liuanglin
 * @date : 2022/4/14 10:28
 * @description : 接口-适配器模式
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Applicator.apply(new FilterAdaptor(new LowPass(1.0)),waveform);
        Applicator.apply(new FilterAdaptor(new HighPass(3.0)),waveform);
        Applicator.apply(new FilterAdaptor(new BandPass(1.0,2.0)),waveform);
        /* output
        Using Processor LowPass
        Waveform{id=0}
        Using Processor HighPass
        Waveform{id=0}
        Using Processor BandPass
        Waveform{id=0}
         */
    }
}

class FilterAdaptor implements Processor {
    Filter filter ;
    public FilterAdaptor(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
