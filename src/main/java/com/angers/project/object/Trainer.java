package com.angers.project.object;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trainer {
    void execute(Animal animal){
        log.info(animal.cry());
    }

    void dogCry(Dog dog){
        execute(dog);
    }

    //字符转换，精度不丢失的情况下直接转换
    int a = 111;
    long al = a;
    double ad = a;
    //字符转换，会丢失精度的情况下还需要转换则需要进行强制转换
    double d = 1.22;
    int di = (int)d;
}
