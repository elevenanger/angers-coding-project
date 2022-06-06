package com.angers.project.onjava8.concurrent;

/**
 * @author : liuanglin
 * @date : 2022/6/6 08:50
 * @description :
 */
public class UnsafeReturn extends IntTestable{
    private int i = 0;

    @Override
    void evenIncrement() {
        i ++;
        i ++;
    }

    @Override
    public int getAsInt() {
        return i;
    }

    public static void main(String[] args) {
        Atomicity.test(new UnsafeReturn());
        /* output :
        测试失败，值为 ： 3
        即使 getAsInt 是原子性操作
        但是测试仍然失败了
        因为缺少 synchronization 保障 evenIncrement()
        会导致其它线程获取到 i 的中间状态
        而且 i 也不是 volatile
        所以两次 i++ 对于其它线程是不可见的
        getValue() 以及 evenIncrement() 都需要是同步操作
         */
    }
}

class SafeReturn extends IntTestable {
    private int i;

    @Override
    synchronized void evenIncrement() {
        i ++;
        i ++;
    }

    @Override
    public synchronized int getAsInt() {
        return i;
    }

    public static void main(String[] args) {
        Atomicity.test(new SafeReturn());
    }
}