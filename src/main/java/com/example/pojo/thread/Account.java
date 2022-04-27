package com.example.pojo.thread;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {
    //显示定义Lock对象
    private final Lock lock = new ReentrantLock();
    //获得指定Lock对象对应的Condition
    private final Condition condition = lock.newCondition();
    //封装账号编号|账户余额的2个成员变量
    private String accountNo;
    private double balance;
    //标识账户中是否已有存款的旗标
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //账户余额不允许随意修改,只提供getter方法
    public double getBalance() {
        return this.balance;
    }

    /*
     * lock(同步锁)|condition控制线程通信
     * lock方法取钱操作
     * */
    public void drawMoney(double drawAmount) {
        lock.lock();
        try {
            if (!flag) {//如果flag为false,表示账户中还没有人存钱进去,取钱方法阻塞
                condition.await();//condition控制线程通信
            } else {
                if (balance >= drawAmount) {
                    System.out.println(Thread.currentThread().getName() + "\t 取钱成功!!!取出钞票: " + drawAmount);
                    balance -= drawAmount;
                    System.out.println("账户余额为: " + balance);
                    flag = false;
                    condition.signalAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 取钱失败!!!余额不足!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /*
     * lock方法存钱操作
     * condition控制线程通信
     * */
    public void depositMoney(double depositMoney) {
        lock.lock();
        try {
            if (flag) {
                condition.await();
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 存款: " + depositMoney);
                balance += depositMoney;
                System.out.println("账户余额为:\t" + balance);
                flag = true;
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /*
     * synchronized(同步方法)
     * 提供一个线程安全的draw()方法来完成取钱操作
     * */
    public synchronized void draw(double Amount) {
        try {
            if (!flag) {
                wait();
            } else {
                if (balance >= Amount) {
                    System.out.println(Thread.currentThread().getName() + "\t 取钱成功!!!取出钞票: " + Amount);
                    balance -= Amount;
                    System.out.println("账户余额为: " + balance);
                    //将标识账户是否已有存款的旗标设为false
                    flag = false;
                    //唤醒其他线程
                    notifyAll();
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 取钱失败!!!余额不足!");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * synchronized(同步方法)
     * 提供一个线程安全的deposit()方法来完成存钱操作
     * */
    public synchronized void deposit(double depositAmount) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 存款: " + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为: " + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //根据accountNo来重写equals()和hashCode()方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && Account.class == o.getClass()) {
            Account account = (Account) o;
            return account.getAccountNo().equals(accountNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
