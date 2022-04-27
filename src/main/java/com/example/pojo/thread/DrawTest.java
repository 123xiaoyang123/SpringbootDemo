package com.example.pojo.thread;

public class DrawTest {
    public static void main(String[] args) {
        //创建一个账户
        Account account=new Account("123",0);

        //创建一个取钱者 三个存钱者来对同一个账户操作
        new DrawThread("取钱者",account,800).start();
        new DepositThread("存钱者1",account,800).start();
        new DepositThread("存钱者2",account,800).start();
        new DepositThread("存钱者3",account,800).start();
    }
}
