package com.angers.project.onjava8.validating;

import java.util.Arrays;

/**
 * @author : liuanglin
 * @date : 2022/4/26 14:38
 * @description :验证-CircularQueue 使用契约设计
 * 循环队列：将顺序队列的首尾相连，将存储队列的表从逻辑上看成一个环，称为循环队列
 * 当到达队列的队尾时将回到队列的开头
 * 在循环队列中，空队列和满队列的队首与队尾相等
 * 循环队列是先进先出的数据结构，最先入队的数据最先出队
 * 假设队列长度为4，数据结构如下
 * [1] [2] [3] [4] [5-1] 表示循环
 * 初始化队列，全部为空
 * [] [] [] []
 * 此时下一个入队(in)和出队(in)的槽位都为0，里面的对象都为空
 * 队列满了的情况
 * [1] [2] [3] [4]
 * 下一个入队和出队的槽位都为[1]
 * 队列未满的情况
 * [1] [2] [] []
 * 下一个入队的槽位为 3
 * 下一个出队的槽位为 1
 * 入队是和出队都是顺时针操作
 * 入队是队尾追赶队首
 * 出队是队首追赶队尾
 * 检查以入队对象都不能为空，则检查 [1] [2] 不能为空
 * 从下一个出队地址[1]开始遍历，一直到入队地址之前，由于队列可能已经发生了环绕
 * 则需要用出队地址对数组长度取模进行运算
 * 检查未入队的空间都为空
 * 则从下一个入队地址开始遍历，直到下一个出队地址，同样，需要对数组长度进行取模
 */
public class CircularQueue {
    // 存放的数据
    private Object [] data;
    // 入队指针
    private int in = 0;
    // 出队指针
    private int out = 0;
    // 队列是否已环绕 false 未 true 已环绕
    private boolean wrapped  = false;
    /**
     * 队列构造函数
     * @param size 队列的大小
     */
    public CircularQueue(int size) {
        data = new Object[size];
        assert invariant();
    }
    /**
     * 判断队列是否为空
     * @return true 是 ， false 否
     */
    public boolean empty(){
        return !wrapped && in == out;
    }
    /**
     * 判断队列是否已满
     * @return true 已满 false 未满
     */
    public boolean full() {
        return wrapped && in == out;
    }
    /**
     * 是否环绕
     * @return true 是 false 否
     */
    public boolean isWrapped(){return wrapped;}
    /**
     * 往队列中插入元素
     * @param item 需要插入的对象
     */
    public void put(Object item){
        // 前置检查条件，不能将空对象插入队列
        preCondition(item != null ,"put null item");
        // 前置检查条件，队列不能已满
        preCondition(!full(),"full queue");
        // 检查队列状态
        assert invariant();
        // 检查通过，则插入元素
        data[in++] = item;
        // 入队元素达到队列长度则说明已经发生了缠绕
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        // 再次检查队列状态
        assert invariant();
    }
    /**
     * 从队列中获取元素
     * @return 获取到的对象
     */
    public Object get(){
        // 前置检查，队列不能为空
        preCondition(!empty(),"queue is empty!");
        // 检查队列状态
        assert invariant();
        // 从出队指针取出对象
        Object returnObj = data[out];
        // 将以出队的队列地址置为空
        data[out] = null;
        // 出队指针进 1
        out ++;
        // 如果此时出队的指针大于队列的长度，满队列中的一个元素已经被取出，队列已经解除了缠绕，将出队指针重置为队首 0
        if (out >= data.length){
            out = 0;
            wrapped = false;
        }
        // 后置检查，取出的对象不能为空
        assert postCondition(returnObj != null,"get null item!");
        assert invariant();
        return returnObj;
    }
    /**
     * 前置检查
     * @param cond 检查条件
     * @param msg 异常信息
     */
    private static void preCondition(boolean cond,String msg){
        if (!cond)throw new CircularQueueException(msg);
    }
    /**
     * 后置检查
     * @param cond 检查条件
     * @param msg 异常信息
     * @return 检查结果
     */
    private static boolean postCondition(boolean cond,String msg){
        if (!cond) throw new CircularQueueException(msg);
        return true;
    }
    private boolean invariant(){
        /*
        确保已入队的对象都不为空
         */
        for (int i = out;i != in; i = (i + 1)% data.length)
            if (data[i] == null)
                throw new CircularQueueException("null in queue!");
        // 确保队列中未入队的槽位都为空
        if (full()) return true;
        for (int i = in; i!=out; i = (i + 1) % data.length)
            if (data[i] != null)
                throw new CircularQueueException("non-null object in empty slot!");
        return true;
    }
    @Override
    public String toString() {
        return "CircularQueue{" +
                "data=" + Arrays.toString(data) +
                ", in=" + in +
                ", out=" + out +
                ", wrapped=" + wrapped +
                '}';
    }
}