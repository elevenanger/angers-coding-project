package com.angers.project.corejava.generic;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class DateInterval extends Pair<LocalDate>{

    @Override
    public void setSecond(LocalDate second){
        if (second.compareTo(getFirst())>=0) super.setSecond(second);
    }

    public static void main(String[]args){
        DateInterval interval = new DateInterval();
        Pair<LocalDate> localDatePair = interval;
        localDatePair.setSecond(LocalDate.now());
        log.info(localDatePair.getSecond().toString());
    }
}
