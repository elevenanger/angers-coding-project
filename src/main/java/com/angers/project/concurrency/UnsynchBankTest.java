package com.angers.project.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnsynchBankTest {

    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE  = 100.00;
    public static final double MAX_AMOUNT = 1000.00;
    public static final int DELAY = 10;

    public static void main (String [] args){

        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);

        /*
         竞争问题：当多个线程同时操作一个数据或者对象的时候，有非原子操作，就可能产生竞争问题，导致存放的数据被污染
         1、加载 accounts[to] 到线程的寄存器
         2、增加金额
         3、将修改后的金额（结果）从线程的寄存器取出，返回给 accounts[to]
         场景：
         1、accounts[to] = 5000 ，线程1取出 accounts[to] 存放到寄存器 r1
         2、线程2取出 accounts[to] 存放到寄存器 r2
         3、线程1进行增加操作，将 5000+500 = 5500 进行存储
         4、线程2进行增加操作，将 5000+900 = 5900 进行存储
         5、线程2将寄存器的值返回给 accounts[to] = 5900
         6、线程1将寄存器的值返回给 accounts[to] = 5500

         如果能保障在线程失去控制之前完成该方法，则数据不会被污染
         */
        for (int i = 0;i< NACCOUNTS;i++){
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true){
                        int toAccount = (int)(bank.getAccounts().length * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        log.info(Arrays.toString(bank.getAccounts()));
                        Thread.sleep((int)(DELAY*Math.random()));
                    }
                }catch (InterruptedException e) {}
            };
            Thread t = new Thread(r,"AsynchThread");
            t.start();
        }
    }
}
