package com.angers.project.corejava.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Bank {


    /*
    java.util.concurrent.atomic 库中使用高效的机器指令在不使用锁的前提下确保操作的原子性
     */
    public static final AtomicLong bankSerial = new AtomicLong(1L);

    private final double [] accounts;

    private final long id;

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

    /*
    条件对象
    当线程进入某段代码，发现由于某些条件无法满足，导致无法继续处理
    使用条件对象管理这种情况：线程取得锁，但是无法进行有效的工作
    在 transfer 方法代码逻辑中，可能存在以下问题：
    转出账户余额不足，等待另外的线程给这个账户转入充足的资金后才能继续
    但是其它的线程现在无法操作该对象，因为当前线程已经获取了排它锁 bankLock
    这时候就需要使用条件对象
    一个锁对象，可以有一个或者多个相关联的条件对象
    使用 newCondition 方法获取一个条件对象
    当 transfer 方法发现条件不满足时，调用 sufficientFunds.await()
    线程将会释放锁，是的其它线程可以增加金额，直到满足条件

    等待取得锁的线程与调用 await 线程的区别：
    一旦线程调用了 await 方法，它便进入了这个条件的 wait set，当锁可用时，线程不会变成 RUNNABLE 状态
    它会等待其它的线程为这个相同的条件调用了 signalAll 方法，这个方法会重新激活所有等待该条件的线程
    等待的线程会从 wait set 中移出，变成 RUNNABLE ，其中一个会取得锁，从之前中断的地方继续执行
    当线程调用了 await ，除非其它线程调用 signalAll 方法，不然它便不会重新激活
    线程可能会因此引发 deadlock 情况

    一旦对象的状态对于 await 的线程有利，都应该调用 signalAll 方法

    除了 signalAll 方法，还有一个 signal 方法
    signalAll 方法是通知 wait set 中所有的线程竞争锁
    signal 方法是从 wait set 中随机获取一个线程取得锁
    signal 方法更高效，但是如果挑选的线程重新进入 await
    但是又没有别的线程可以调用 signal 方法
    系统将会进入 deadlock
     */
    private final Condition sufficientFunds;

    /**
     * 通过给定的账户数量和金额，初始化银行
     * @param numbers 账户数量
     * @param initialBalance 初始化的金额
     */
    public Bank(int numbers,double initialBalance){
        this.accounts = new double[numbers];
        Arrays.fill(accounts,initialBalance);
        sufficientFunds = bankLock.newCondition();
        this.id = bankSerial.incrementAndGet();
    }

    /**
     * 转账，从本行的一个账户转出到另一个账户
     * @param debitAccount 借方账户
     * @param creditAccount 贷方账户
     * @param amount 转账金额
     */
    public void transfer(int debitAccount,int creditAccount,double amount){

        log.info(Long.toString(id));
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
                sufficientFunds.await(); // 条件不满足时，释放锁，进入await
            }
            accounts[debitAccount] -= amount;
            accounts[creditAccount] += amount;
            log.info("从 " + debitAccount + " 转账 " + amount + " 元至 " +creditAccount);
            sufficientFunds.signalAll(); // 发生金额变动，可能满足 await 线程的条件，发送通知
            log.info(Double.toString(getTotalBalance()));
        } catch (InterruptedException e) {
            log.error("interrupted",e);
            Thread.currentThread().interrupt();
        } finally {
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
     * synchronized 转账方法
     * @param debitAccount 转出账户
     * @param creditAccount 转入账户
     * @param amount 进入
     * @throws InterruptedException 线程异常
     *
     * 每个 Java 对象都有一个内在锁
     * 如果一个方法被声明为 synchronized ，内在锁将保护整个方法
     * 内在锁有一个关联条件
     * 使用 wait 方法将触发条件的线程添加到 wait set
     * 使用 notifyAll 进行通知
     *
     * 可以将 static 方法声明为 synchronized
     * 这种方法一旦被调用，它会获取所有该类相关对象的内在锁
     *
     * 内在锁的限制：
     * 1、不能中断尝试获取锁的线程
     * 2、不能指定获取锁的超时时间
     * 3、每个锁都有一个单一的条件，效率低下
     *
     * 最好不要使用 Lock / Condition 或者 synchronized
     * 大部分情况下 java.util.concurrent 库的方法已经可以满足需求
     * 如果需要使用， synchronized 可以满足条件，则使用 synchronized 可以简化代码以及减少出错的几率
     * 如果需要 Lock / Condition 的额外能力，才使用 Lock / Condition
     */
    public synchronized void synchronizeTransfer(int debitAccount,int creditAccount,double amount)
            throws InterruptedException {
        while (accounts[debitAccount]<amount){
            wait();
        }
        accounts[debitAccount] -= amount;
        accounts[creditAccount] += amount;
        log.info("从 " + debitAccount + " 转账 " + amount + " 元至 " +creditAccount);
        notifyAll();
    }

    /**
     * 计算账户的总余额
     * @return 总余额
     */
    public double getTotalBalance(){
        bankLock.lock();
        try{
            double sum = 0;
            for (double amount: accounts) {
                sum += amount;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

}
