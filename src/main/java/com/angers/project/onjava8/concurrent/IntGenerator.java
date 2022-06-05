package com.angers.project.onjava8.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : liuanglin
 * @date : 2022/6/5 20:13
 * @description :
 */
public abstract class IntGenerator {
    private AtomicBoolean canceled = new AtomicBoolean();
    public abstract int next();
    public void cancel() {canceled.set(true);}
    public boolean isCanceled(){return canceled.get();}
}
