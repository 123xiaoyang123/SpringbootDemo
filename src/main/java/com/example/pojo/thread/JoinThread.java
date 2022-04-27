package com.example.pojo.thread;
/*
* join线程
* */
public class JoinThread extends Thread{

    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"-"+i);
        }
    }

    public static void main(String[] args) throws Exception{
        new JoinThread("NewThread").start();
        for (int i = 0; i < 200; i++) {
            if (i==30){
                JoinThread jt=new JoinThread("新加的join线程-");
                jt.start();
                jt.join();
            }
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }

}
