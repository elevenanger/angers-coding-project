package com.angers.project.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

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

    /**
     * 通过给定的账户数量和金额，初始化银行
     * @param numbers 账户数量
     * @param initialBalance 初始化的金额
     */
    public Bank(int numbers,double initialBalance){
        this.accounts = new double[numbers];
        Arrays.fill(accounts,initialBalance);
    }

    /**
     * 转账，从本行的一个账户转出到另一个账户
     * @param debitAccount 借方账户
     * @param creditAccount 贷方账户
     * @param amount 转账金额
     */
    public void transfer(int debitAccount,int creditAccount,double amount){
        log.info(Thread.currentThread().toString());
        if (accounts[debitAccount]<amount){
            log.info(debitAccount+"账户，余额不足。");
        } else {
            accounts[debitAccount] -= amount;
            log.info("从 " + debitAccount + " 转账 " + amount + " 元至 " +creditAccount);
            accounts[creditAccount] += amount;
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
