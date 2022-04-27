package com.example.pojo.thread;

public class DrawThread extends Thread {
    //模拟用户账户
    private Account account;
    //当前取钱线程所希望取的钱数
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            account.drawMoney(drawAmount);
        }
//        //lock 同步锁方法
//        account.drawMoney(drawAmount);
    }
}
