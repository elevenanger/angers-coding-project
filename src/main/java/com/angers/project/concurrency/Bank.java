package com.angers.project.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {


    private final double [] accounts;

    /**
     * 账户列表
     * @return 账户列表
     */
    public double [] getAccounts(){
        return this.accounts;
    }

    /*
    ReentrantLock() 锁，确保同一时间只有一个线程能够访问锁保护的关键代码
    之所以名称叫做 Reentrant 是因为线程可以重复取得已经拥有的锁
    锁有一个持有数量，追踪对于锁定方法的调用
    比如调用 Bank.transfer() , hold count = 1
    transfer() 方法里面调用 getTotalBalance() , hold count +1 = 2
    getTotalBalance() 方法结束 , hold count -1 = 1
    transfer() 方法结束， hold count -1 = 0
    释放锁

    使用锁来保护可以检查或者修改共享对象的代码块
    可以确保这些操作在其他线程可以操作对象之前完成
     */
    private final Lock bankLock = new ReentrantLock();

    private Condition sufficientFunds;

    /**
     * 通过给定的账户数量和金额，初始化银行
     * @param numbers 账户数量
     * @param initialBalance 初始化的金额
     */
    public Bank(int numbers,double initialBalance){
        this.accounts = new double[numbers];
        Arrays.fill(accounts,initialBalance);
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 转账，从本行的一个账户转出到另一个账户
     * @param debitAccount 借方账户
     * @param creditAccount 贷方账户
     * @param amount 转账金额
     */
    public void transfer(int debitAccount,int creditAccount,double amount){
        /*
        对于后面的逻辑进行加锁操作，只有一个线程能够访问该对象方法后面的代码逻辑
        这个锁作用于当前的 Bank 实例上
        不同实例之间的锁互不影响
         */
        bankLock.lock();
        try {
            log.info(Thread.currentThread().toString());
            while(accounts[debitAccount]<amount){
                log.info(debitAccount+" 账户余额不足");
            }
            accounts[debitAccount] -= amount;
            log.info("从 " + debitAccount + " 转账 " + amount + " 元至 " +creditAccount);
            accounts[creditAccount] += amount;
            log.info(Double.toString(getTotalBalance()));
        }finally {
            /*
             解锁操作，确保解锁的逻辑在 finally 块中
             如果业务逻辑抛出异常，锁可以被正常的释放
             如果要加锁，不能使用 try-with-resource 语句
             因为没有 finally 逻辑，close 不会释放锁
             */
            bankLock.unlock();
        }
    }

    /**
     * 计算账户的总余额
     * @return 总余额
     */
    public double getTotalBalance(){
        double sum = 0;
        for (double amount: accounts) {
            sum += amount;
        }
        return sum;
    }


}
